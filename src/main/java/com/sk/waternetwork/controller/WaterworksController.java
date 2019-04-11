package com.sk.waternetwork.controller;

import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.mapper.WaterworksMapper;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.RandomGUID;
import com.sk.waternetwork.model.Waterworks;
import com.sk.waternetwork.service.WaterworksService;
import com.sk.waternetwork.viewModel.SelectWaterworksModel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Administrator on 2019/3/26.
 */
@RestController
public class WaterworksController {
    @Autowired
    private WaterworksService waterworksService;
    @Autowired
    private WaterworksMapper waterworksMapper;
    /**
     * 根据公司编码查询水厂
     */
    @RequestMapping(value = "/getWaterworksByCompanyCode", method = RequestMethod.GET)
    public JSONMessageView getWaterworksByCompanyCode(@RequestParam String CompanyCode, @RequestParam(defaultValue = "1") Integer page,
                                                       @RequestParam(defaultValue = "10") Integer size) {
        JSONMessageView json = new JSONMessageView();
        PageInfo pageInfo = waterworksService.getWaterworksByCompanyCode(CompanyCode, page, size);
        if (pageInfo.getList() != null) {
            if (pageInfo.getList().size() != 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(pageInfo);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败");
            }
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
    /**
     * 水厂添加接口
     */
    @RequestMapping(value = "/insertWaterworks", method = RequestMethod.POST)
    public JSONMessageView insertWaterworks(@RequestBody Waterworks waterworks) {
        JSONMessageView json = new JSONMessageView();
        waterworks.setCode(RandomGUID.createCode());
        waterworks.setCreatetime(new Date());
        try {
            int count = waterworksMapper.insertSelective(waterworks);
            if (count > 0) {
                json.setCode(0);
                json.setMessage("增添成功");
            } else {
                json.setCode(-1);
                json.setMessage("增添失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    /**
     * 水厂删除接口
     */
    @ApiOperation(value = "水厂删除" ,  notes="水厂删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "水厂编码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/deleteWaterworks", method = RequestMethod.GET)
    public JSONMessageView deleteWaterworksByCode(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            int count = waterworksMapper.deleteByPrimaryKey(code);
            if (count > 0) {
                json.setCode(0);
                json.setMessage("删除成功");
            } else {
                json.setCode(-1);
                json.setMessage("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    /**
     * 水厂修改接口
     */
    @RequestMapping(value = "/updateWaterworks", method = RequestMethod.POST)
    public JSONMessageView updateWaterworks(@RequestBody Waterworks waterworks) {
        JSONMessageView json = new JSONMessageView();
        waterworks.setModifytime(new Date());
        try {
            int count = waterworksMapper.updateByPrimaryKeySelective(waterworks);
            if (count > 0) {
                json.setCode(0);
                json.setMessage("修改成功");
            } else {
                json.setCode(-1);
                json.setMessage("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }
    /**
     * 多条件查询水厂
     */
    @RequestMapping(value = "/selectWaterworksByCondition", method = RequestMethod.POST)
    public JSONMessageView selectWaterworksByCondition(@RequestBody SelectWaterworksModel selectWaterworksModel) {
        JSONMessageView json = new JSONMessageView();
        PageInfo pageInfo = waterworksService.selectWaterworksByCondition(selectWaterworksModel);
        if (pageInfo.getList() != null) {
            if (pageInfo.getList().size() != 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(pageInfo);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败,没有符合条件的结果");
            }
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
}
