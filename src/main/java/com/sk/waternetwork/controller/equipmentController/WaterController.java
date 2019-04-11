package com.sk.waternetwork.controller.equipmentController;

import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.mapper.AllEquipmentMapper;
import com.sk.waternetwork.mapper.WaterMapper;
import com.sk.waternetwork.mapper.WaterpumpMapper;
import com.sk.waternetwork.model.*;
import com.sk.waternetwork.service.equipmentService.EquipmentParamService;
import com.sk.waternetwork.service.equipmentService.WaterService;
import com.sk.waternetwork.service.equipmentService.WaterpumpService;
import com.sk.waternetwork.viewModel.SaveWaterParamViewModel;
import com.sk.waternetwork.viewModel.SaveWaterPumpParamViewModel;
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
public class WaterController {
    @Autowired
    WaterService waterService;
    @Autowired
    WaterMapper waterMapper;
    @Autowired
    EquipmentParamService equipmentParamService;
    @Autowired
    AllEquipmentMapper allEquipmentMapper;

    //通过名字查询水表
    @RequestMapping(value = "/selectWaterByName",method = RequestMethod.GET)
    public JSONMessageView  selectWaterByName(@RequestParam String name,@RequestParam String companycode, @RequestParam(defaultValue = "1") Integer page,
                                                  @RequestParam(defaultValue = "10") Integer size){
        JSONMessageView json=new JSONMessageView();
        PageInfo pageInfo=waterService.selectWaterByName(name, companycode, page, size);

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



//新增水表
    @RequestMapping(value = "/insertWater",method = RequestMethod.POST)
    public JSONMessageView insertWater(@RequestBody Water water ){
        JSONMessageView json=new JSONMessageView();
        water.setCode(RandomGUID.createCode());
        water.setCreatetime(new Date());
        try{
            int count=waterMapper.insertSelective(water);

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
//修改水表
    @RequestMapping(value = "/updateWater",method = RequestMethod.POST)
    public JSONMessageView updateWater(@RequestBody  Water water){
        JSONMessageView json=new JSONMessageView();
        water.setModifytime(new Date());
        try{
            int count=waterMapper.updateByPrimaryKeySelective(water);

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
//删除水表
    @RequestMapping(value = "/deleteWater" ,method = RequestMethod.GET)
    public JSONMessageView deleteWater(@RequestParam String code){
        JSONMessageView json= new  JSONMessageView();
        int count = waterService.deleteWater(code);
        if (count ==1) {
            json.setCode(0);
            json.setMessage("删除成功");
        }else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;

    }


    //新增水表和水表参数
    @RequestMapping(value = "/saveWaterParam",method = RequestMethod.POST)
    public JSONMessageView  saveWaterParam(@RequestBody SaveWaterParamViewModel saveWaterParamViewModel){
        JSONMessageView  json=new JSONMessageView();

        int count= equipmentParamService.saveWaterParam(saveWaterParamViewModel);

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
