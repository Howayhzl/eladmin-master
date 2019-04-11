package com.sk.waternetwork.controller;

import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.service.DeviceManageService;
import com.sk.waternetwork.viewModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/23.
 */
@RestController
public class DeviceManageController {
    /*@Autowired
    private DeviceManageService deviceManageService;

    @RequestMapping(value = "/insertWaterpump", method = RequestMethod.POST)
    public JSONMessageView insertWaterpump(@RequestBody InsertWaterpumpModel insertWaterpumpModel) {
        JSONMessageView json = new JSONMessageView();
        int count = deviceManageService.insertWaterpump(insertWaterpumpModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("增添成功");
        } else if (count == 0) {
            json.setCode(-1);
            json.setMessage("增添失败");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
    @RequestMapping(value = "/insertValve", method = RequestMethod.POST)
    public JSONMessageView insertValve(@RequestBody InsertValveModel insertValveModel) {
        JSONMessageView json = new JSONMessageView();
        int count = deviceManageService.insertValve(insertValveModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("增添成功");
        } else if (count == 0) {
            json.setCode(-1);
            json.setMessage("增添失败");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
    @RequestMapping(value = "/insertPipelineInformation", method = RequestMethod.POST)
    public JSONMessageView insertPipelineInformation(@RequestBody InsertPipelineInformationModel insertPipelineInformationModel) {
        JSONMessageView json = new JSONMessageView();
        int count = deviceManageService.insertPipelineInformation(insertPipelineInformationModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("增添成功");
        } else if (count == 0) {
            json.setCode(-1);
            json.setMessage("增添失败");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
    @RequestMapping(value = "/insertWaterQuality", method = RequestMethod.POST)
    public JSONMessageView insertWaterQuality(@RequestBody InsertWaterQualityModel insertWaterQualityModel) {
        JSONMessageView json = new JSONMessageView();
        int count = deviceManageService.insertWaterQuality(insertWaterQualityModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("增添成功");
        } else if (count == 0) {
            json.setCode(-1);
            json.setMessage("增添失败");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
    @RequestMapping(value = "/insertWater", method = RequestMethod.POST)
    public JSONMessageView insertWater(@RequestBody InsertWaterModel insertWaterModel) {
        JSONMessageView json = new JSONMessageView();
        int count = deviceManageService.insertWater(insertWaterModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("增添成功");
        } else if (count == 0) {
            json.setCode(-1);
            json.setMessage("增添失败");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
    @RequestMapping(value = "/insertFlowmeter", method = RequestMethod.POST)
    public JSONMessageView insertFlowmeter(@RequestBody InsertFlowmeterModel insertFlowmeterModel) {
        JSONMessageView json = new JSONMessageView();
        int count = deviceManageService.insertFlowmeter(insertFlowmeterModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("增添成功");
        } else if (count == 0) {
            json.setCode(-1);
            json.setMessage("增添失败");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
    @RequestMapping(value = "/insertWaterSource", method = RequestMethod.POST)
    public JSONMessageView insertWaterSource(@RequestBody InsertWaterSourceModel insertWaterSourceModel) {
        JSONMessageView json = new JSONMessageView();
        int count = deviceManageService.insertWaterSource(insertWaterSourceModel);
        if (count > 0) {
            json.setCode(0);
            json.setMessage("增添成功");
        } else if (count == 0) {
            json.setCode(-1);
            json.setMessage("增添失败");
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }*/
}
