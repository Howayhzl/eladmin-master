package com.sk.waternetwork.controller;

import com.sk.waternetwork.common.RedisTest;
import com.sk.waternetwork.mapper.CompanyManageMapper;
import com.sk.waternetwork.mapper.HomeMapper;
import com.sk.waternetwork.mapper.PipelineInformationMapper;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.service.HomeService;
import com.sk.waternetwork.viewModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lujintao on 2019/2/11.
 * 首页控制器
 */
@RestController
public class HomeController {
    @Autowired
    private PipelineInformationMapper pipelineinfoMapper;
    @Autowired
    private CompanyManageMapper companyManageMapper;
    @Autowired
    private HomeService homeService;
    @Autowired
    private HomeMapper homeMapper;

    /**
     * 根据公司编码获取管线数据
     */
    @RequestMapping(value = "/GetPipelineInfo", method = RequestMethod.GET)
    public JSONMessageView getPipelineInfoByCompanyCode(String CompanyCode) {
        JSONMessageView json = new JSONMessageView();
        List<PipelineViewModel> object = RedisTest.getgetPipelineByCompanyCode(CompanyCode);
        if (object != null) {
            json.setCode(0);
            json.setMessage("查询成功");
            json.setContent(object);
        } else {
            json.setCode(-1);
            json.setMessage("查询失败");
        }
        /*List<PipelineViewModel> pipelineViewModelList = homeService.getPipelineByCompanyCode(CompanyCode);
        if (pipelineViewModelList != null) {
            if (pipelineViewModelList.size() != 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(pipelineViewModelList);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败");
            }
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }*/
        return json;
    }

    /**
     * 查询子公司及区域列表
     */
    @RequestMapping(value = "/getSubsidiaryAreas", method = RequestMethod.GET)
    public JSONMessageView getSubsidiaryAreasByCompanyCode(String CompanyCode) {
        JSONMessageView json = new JSONMessageView();
        SubsidiaryAreasViewModel s = homeService.getSubsidiaryAreasByCompanyCode(CompanyCode);
        if (s != null) {
            if (s.getAreasInfoList().size() != 0 || s.getCompanyList().size() != 0) {
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
            return json;
        }
        return json;
    }

    /**
     * 获取站点绑定设备实时数据
     */
    @RequestMapping(value = "/getRealtimeDataBySiteCode", method = RequestMethod.GET)
    public JSONMessageView getRealtimeDataBySiteCode(String siteCode, String companyCode) {
        JSONMessageView json = new JSONMessageView();
        RealtimeDataViewModel r = homeService.getRealtimeDataBySiteCode(siteCode, companyCode);
        if (r != null) {
            if (r.getWaterpumpRealtimeModelList().size() != 0 || r.getWaterRealtimeModelList().size() != 0 || r.getFlowmeterRealtimeModelList().size() != 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(r);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败");
            }
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    /**
     * 获取报警信息列表
     */
    @RequestMapping(value = "/getWarningByCompanyCode", method = RequestMethod.GET)
    public JSONMessageView getWarningByCompanyCode(@RequestParam String companyCode, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "10") Integer size) {
        JSONMessageView json = new JSONMessageView();
        WarningListViewModel warningListViewModel = homeService.getWarninglistByCompanyCode(companyCode, page, size);
        if (warningListViewModel.getPageInfo().getList() != null) {
            if (warningListViewModel.getPageInfo().getList().size() != 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(warningListViewModel);
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
     * 获取管线口径列表
     */
    @RequestMapping(value = "/getPipeDiameterByCompanyCode", method = RequestMethod.GET)
    public JSONMessageView getPipeDiameterByCompanyCode(@RequestParam String companyCode) {
        JSONMessageView json = new JSONMessageView();
        try {
            List<String> list = homeMapper.getPipeDiameterByCompanyCode(companyCode);
            if (list.size() > 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(list);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败");
            }
        } catch (Exception e) {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }

}
