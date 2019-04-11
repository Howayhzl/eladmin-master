package com.sk.waternetwork.controller;

import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.mapper.AllEquipmentMapper;
import com.sk.waternetwork.mapper.SiteMapper;
import com.sk.waternetwork.model.*;
import com.sk.waternetwork.service.SiteService;
import com.sk.waternetwork.service.equipmentService.EquipmentSiteService;
import com.sk.waternetwork.viewModel.AllEquimentViewModel;
import com.sk.waternetwork.viewModel.SelectSiteModel;
import com.sk.waternetwork.viewModel.SiteEquipmentViewModel;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Copyright by Xunge Software 2018. All right reserved
 *
 * @author YangWL
 * @date 2019/2/12 0012
 * @Description:
 */
@RestController
public class SiteController {
    @Autowired
    private SiteService siteService;
    @Autowired
    private SiteMapper siteMapper;
    @Autowired
    private EquipmentSiteService equipmentSiteService;
    /**
     * 多条件查询站点
     */
    @RequestMapping(value = "/selectSiteByByCondition", method = RequestMethod.POST)
    public JSONMessageView selectSiteByByCondition(@RequestBody SelectSiteModel selectSiteModel) {
        JSONMessageView json = new JSONMessageView();
        PageInfo pageInfo = siteService.selectSiteByCondition(selectSiteModel);
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

    //新增站点
    @RequestMapping(value = "/insertSite", method = RequestMethod.POST)
    public JSONMessageView insertSite(@RequestBody Site site) {
        JSONMessageView json = new JSONMessageView();
        site.setCode(RandomGUID.createCode());
        site.setCreatetime(new Date());
        try {
            int count = siteMapper.insertSelective(site);

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

    //修改站点
    @RequestMapping(value = "/updateSite", method = RequestMethod.POST)
    public JSONMessageView updateSite(@RequestBody Site site) {
        JSONMessageView json = new JSONMessageView();
        site.setModifytime(new Date());
        try {
            int count = siteMapper.updateByPrimaryKeySelective(site);

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

    //删除站点
    @RequestMapping(value = "/deleteSite", method = RequestMethod.GET)
    public JSONMessageView deleteSite(@RequestParam String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            int count = siteMapper.deleteByPrimaryKey(code);
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

    //通过公司编码查询站点
    @RequestMapping(value = "/selectSiteByCompanyCode", method = RequestMethod.GET)
    public JSONMessageView selectSiteByCompanyCode(@RequestParam String companycode) {
        JSONMessageView json = new JSONMessageView();
        List siteList = siteService.selectSiteByCompanyCode(companycode);
        if (siteList != null) {
            if (siteList.size() != 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(siteList);
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

    //通过公司编码查询所有设备
    @RequestMapping(value = "/selectEquipmentByCompanyCode", method = RequestMethod.GET)
    public JSONMessageView getEquipmentByCompanyCode(@RequestParam String companycode) {
        JSONMessageView json = new JSONMessageView();
        AllEquimentViewModel a = siteService.getEquipmentByCompanyCode(companycode);
        if (a != null) {
            if (a.getFlowmeterList() != null || a.getWaterpumpList() != null ||
                    a.getWaterList() != null) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(a);
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

    //绑定站点设备
    @RequestMapping(value = "/bindEquipmentSite", method = RequestMethod.POST)
    public JSONMessageView bindEquipmentSite(@RequestBody SiteEquipmentViewModel siteEquipmentViewModel) {
        JSONMessageView json = new JSONMessageView();
        int count = equipmentSiteService.bindEquipmentSite(siteEquipmentViewModel);
        if (count == 0) {
            json.setCode(0);
            json.setMessage("绑定成功");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }

    //通过站点编码查询绑定设备
    @RequestMapping(value = "/selectBindEquipmentSiteBySiteCode", method = RequestMethod.GET)
    public JSONMessageView selectBindEquipmentSiteBySiteCode(@RequestParam String sitecode) {
        JSONMessageView json = new JSONMessageView();
        List<SiteEquipmentRelationship> s = equipmentSiteService.selectBindEquipmentSiteBySiteCode(sitecode);
        if (s != null) {
            if (s.size() != 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(s);
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
}

