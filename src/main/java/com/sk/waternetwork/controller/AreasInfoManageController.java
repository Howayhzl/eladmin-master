package com.sk.waternetwork.controller;

import com.sk.waternetwork.mapper.AreasInfoManageMapper;
import com.sk.waternetwork.mapper.AreasInfoMapper;
import com.sk.waternetwork.mapper.HomeMapper;
import com.sk.waternetwork.model.AreasInfo;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.RandomGUID;
import com.sk.waternetwork.model.Site;
import com.sk.waternetwork.service.AreasInfoManageService;
import com.sk.waternetwork.viewModel.AreasSiteViewModel;
import com.sk.waternetwork.viewModel.SaveAreasViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/1/15.
 */
@RestController
public class AreasInfoManageController {
    @Autowired
    private AreasInfoMapper areasInfoMapper;
    @Autowired
    private AreasInfoManageService areasInfoManageService;
    @Autowired
    private AreasInfoManageMapper areasInfoManageMapper;
    @Autowired
    private HomeMapper homeMapper;

    /**
     * 新增区域
     */
    @RequestMapping(value = "/insertAreas", method = RequestMethod.POST)
    public JSONMessageView insertAreas(@RequestBody AreasInfo areasInfo) {
        JSONMessageView json = new JSONMessageView();
        areasInfo.setAreacode(RandomGUID.createCode());
        areasInfo.setCreatetime(new Date());
        if (areasInfo.getParentnode() == null) {
            areasInfo.setParentnode("");
        }
        try {
            int count = areasInfoMapper.insertSelective(areasInfo);
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
     * 区域删除
     */
    @RequestMapping(value = "/deleteAreas", method = RequestMethod.GET)
    public JSONMessageView deleteAreasByCode(String code) {
        JSONMessageView json = new JSONMessageView();
        int count = areasInfoManageService.deleteAreasByCode(code);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("删除成功");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }

    /**
     * 区域编辑
     */
    @RequestMapping(value = "/updateAreas", method = RequestMethod.POST)
    public JSONMessageView updateAreas(@RequestBody AreasInfo areasInfo) {
        JSONMessageView json = new JSONMessageView();
        areasInfo.setModifytime(new Date());
        try {
            int count = areasInfoMapper.updateByPrimaryKeySelective(areasInfo);
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
     * 查询区域绑定站点信息
     */
    @RequestMapping(value = "/selectAreasSite", method = RequestMethod.GET)
    public JSONMessageView getSiteByAreaCode(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            List<Site> siteList = areasInfoManageMapper.selectAreasSiteByAreaCode(code);
            json.setCode(0);
            json.setMessage("查询成功");
            json.setContent(siteList);
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    /**
     * 维护绑定站点命令
     */
    @RequestMapping(value = "/bindSite", method = RequestMethod.POST)
    public JSONMessageView bindSite(@RequestBody AreasSiteViewModel areasSiteViewModel) {
        JSONMessageView json = new JSONMessageView();
        int count = areasInfoManageService.bindSite(areasSiteViewModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("绑定成功");
        } else if (count == 0) {
            json.setCode(-1);
            json.setMessage("绑定失败");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }

    /**
     * 查询子节点区域
     */
    @RequestMapping(value = "/selectChildnodeAreas", method = RequestMethod.GET)
    public JSONMessageView selectAreasByParentNode(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            List<AreasInfo> areasInfoList = areasInfoManageMapper.selectAreasByParentNode(code);
            if (areasInfoList.size() > 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(areasInfoList);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败");
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
     * 查询区域信息列表
     */
    @RequestMapping(value = "/selectAreasInfo", method = RequestMethod.GET)
    public JSONMessageView selectAreasInfoByCompanyCode(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            List<AreasInfo> areasInfoList = homeMapper.getAreasByCompanyCode(code);
            if (areasInfoList.size() > 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(areasInfoList);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败");
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
     * 保存区域
     */
    @RequestMapping(value = "/saveAreas", method = RequestMethod.POST)
    public JSONMessageView saveAreas(@RequestBody SaveAreasViewModel saveAreasViewModel) {
        JSONMessageView json = new JSONMessageView();
        int count = areasInfoManageService.saveAreas(saveAreasViewModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("保存成功");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
}
