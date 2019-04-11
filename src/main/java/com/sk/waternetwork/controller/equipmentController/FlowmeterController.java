package com.sk.waternetwork.controller.equipmentController;

import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.mapper.FlowmeterMapper;
import com.sk.waternetwork.model.Flowmeter;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.RandomGUID;
import com.sk.waternetwork.model.Water;
import com.sk.waternetwork.service.equipmentService.EquipmentParamService;
import com.sk.waternetwork.service.equipmentService.FlowmeterService;
import com.sk.waternetwork.viewModel.SaveFlowMeterParamViewModel;
import com.sk.waternetwork.viewModel.SaveWaterParamViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Copyright by Xunge Software 2018. All right reserved
 *
 * @author YangWL
 * @date 2019/2/15 0015
 * @Description:
 */
@RestController
public class FlowmeterController {
    @Autowired
    FlowmeterMapper flowmeterMapper;
    @Autowired
    FlowmeterService flowmeterService;
    @Autowired
    EquipmentParamService equipmentParamService;
    //通过姓名查询流量计
    @RequestMapping(value = "/selectFlowmeterByName",method = RequestMethod.GET)
    public JSONMessageView  selectFlowmeterByName(@RequestParam String name,@RequestParam String companycode, @RequestParam(defaultValue = "1") Integer page,
                                              @RequestParam(defaultValue = "10") Integer size){
        JSONMessageView json=new JSONMessageView();
        PageInfo pageInfo=flowmeterService.selectFlowmeterByName(name,companycode,page,size);

        if(pageInfo!=null){
            if(pageInfo.getList().size()!=0){
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(pageInfo);

            }else{
                json.setCode(-1);
                json.setMessage("查询失败");
            }

        }else{
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }



//新增流量计
    @RequestMapping(value = "/insertFlowmeter",method = RequestMethod.POST)
    public JSONMessageView insertFlowmeter(@RequestBody Flowmeter flowmeter){
        JSONMessageView json=new JSONMessageView();
       flowmeter.setCode(RandomGUID.createCode());
        flowmeter.setCreatetime(new Date());
        try{
            int count=flowmeterMapper.insertSelective(flowmeter);

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
//修改流量计
    @RequestMapping(value = "/updateFlowmeter",method = RequestMethod.POST)
    public JSONMessageView updateFlowmeter(@RequestBody  Flowmeter flowmeter){
        JSONMessageView json=new JSONMessageView();
        flowmeter.setModifytime(new Date());
        try{
            int count=flowmeterMapper.updateByPrimaryKeySelective(flowmeter);

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
//删除流量计
    @RequestMapping(value = "/deleteFlowmeter" ,method = RequestMethod.GET)
    public JSONMessageView deleteFlowmeter(@RequestParam String code){
        JSONMessageView json= new  JSONMessageView();
        int count = flowmeterService.deleteFlowmeter(code);
        if (count ==1) {
            json.setCode(0);
            json.setMessage("删除成功");
        }else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;

    }





    //新增流量计和流量计参数
    @RequestMapping(value = "/saveFlowMeterParam",method = RequestMethod.POST)
    public JSONMessageView  saveFlowMeterParam(@RequestBody SaveFlowMeterParamViewModel saveFlowMeterParamViewModel){
        JSONMessageView  json=new JSONMessageView();

        int count=equipmentParamService.saveFlowMeterParam(saveFlowMeterParamViewModel);

        if(count>0){
            json.setCode(0);
            json.setMessage("保存成功");
        }else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }



        return json;

    }

}
