package com.sk.waternetwork.controller;

import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.mapper.WaterSourceMapper;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.RandomGUID;
import com.sk.waternetwork.model.WaterSource;
import com.sk.waternetwork.service.WaterSourceService;
import com.sk.waternetwork.viewModel.SelectWaterSourceModel;
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
public class WaterSourceControll {
    @Autowired
    private WaterSourceService waterSourceService;
    @Autowired
    private WaterSourceMapper waterSourceMapper;
    /**
     * 根据公司编码查询水源
     */
    @RequestMapping(value = "/getWaterSourceByCompanyCode", method = RequestMethod.GET)
    public JSONMessageView getWaterSourceByCompanyCode(@RequestParam String CompanyCode, @RequestParam(defaultValue = "1") Integer page,
                                                           @RequestParam(defaultValue = "10") Integer size) {
        JSONMessageView json = new JSONMessageView();
        PageInfo pageInfo = waterSourceService.getWaterSourceByCompanyCode(CompanyCode, page, size);
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
     * 水源添加接口
     */
    @RequestMapping(value = "/insertWaterSource", method = RequestMethod.POST)
    public JSONMessageView insertWaterSource(@RequestBody WaterSource waterSource) {
        JSONMessageView json = new JSONMessageView();
        waterSource.setCode(RandomGUID.createCode());
        waterSource.setCreatetime(new Date());
        try {
            int count = waterSourceMapper.insertSelective(waterSource);
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
     * 水源删除接口
     */
    @ApiOperation(value = "水源删除" ,  notes="水源删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "水源编码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/deleteWaterSource", method = RequestMethod.GET)
    public JSONMessageView deleteWaterSourceByCode(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            int count = waterSourceMapper.deleteByPrimaryKey(code);
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
     * 水源修改接口
     */
    @RequestMapping(value = "/updateWaterSource", method = RequestMethod.POST)
    public JSONMessageView updateWaterSource(@RequestBody WaterSource waterSource) {
        JSONMessageView json = new JSONMessageView();
        waterSource.setModifytime(new Date());
        try {
            int count = waterSourceMapper.updateByPrimaryKeySelective(waterSource);
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
     * 多条件查询水源
     */
    @RequestMapping(value = "/selectWaterSourceByCondition", method = RequestMethod.POST)
    public JSONMessageView selectWaterSourceByCondition(@RequestBody SelectWaterSourceModel selectWaterSourceModel) {
        JSONMessageView json = new JSONMessageView();
        PageInfo pageInfo = waterSourceService.selectWaterSourceByCondition(selectWaterSourceModel);
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
