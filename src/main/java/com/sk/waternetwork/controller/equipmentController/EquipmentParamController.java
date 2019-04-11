package com.sk.waternetwork.controller.equipmentController;

import com.sk.waternetwork.model.EquipmentParam;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.service.equipmentService.EquipmentParamService;
import com.sk.waternetwork.viewModel.EquipmentSetParamViewModel;
import com.sk.waternetwork.viewModel.UpdateEquipmentParamByCodeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright by Xunge Software 2018. All right reserved
 *
 * @author YangWL
 * @date 2019/2/27 0027
 * @Description:
 */
@RestController
public class EquipmentParamController {
    @Autowired
    EquipmentParamService equipmentParamService;

    //设置参数接口
    @RequestMapping(value = "/setParam" ,method = RequestMethod.POST)
    public JSONMessageView setParam(@RequestBody EquipmentSetParamViewModel equipmentSetParamViewModel){
        JSONMessageView json=new JSONMessageView();
        int count = equipmentParamService.setParam(equipmentSetParamViewModel);
        if(count==0){
            json.setCode(1);
            json.setMessage("设置成功");
        }  else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return  json;

    }
    

//根据设备编码查询设备参数接口
    @RequestMapping(value = "/selectEquipmentParamByEquipment",method = RequestMethod.GET)
    public  JSONMessageView selectEquipmentParamByEquipment(@RequestParam String equipmentcode) {
        JSONMessageView json = new JSONMessageView();
        List<EquipmentParam> e = equipmentParamService.selectEquipmentParamByEquipment(equipmentcode);
        if (e != null) {
            if (e.size() != 0) {
                json.setCode(1);
                json.setMessage("设置成功");
                json.setContent(e);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败");
            }
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return  json;
    }

//通过编码修改设备参数状态
    @RequestMapping(value = "/updateStateByCode",method = RequestMethod.POST)
    public  JSONMessageView  updateStateByCode(@RequestBody UpdateEquipmentParamByCodeViewModel updateEquipmentParamByCodeViewModel){
        JSONMessageView json=new JSONMessageView();

        int count=equipmentParamService.updateStateByCode(updateEquipmentParamByCodeViewModel);
        if (count == 1) {
            json.setCode(0);
            json.setMessage("修改成功");
        } else if(count==-1) {
            json.setCode(-1);
            json.setMessage("修改失败");
        }
     else {

        json.setCode(-10);
        json.setMessage("操作异常");
        return json;
    }
        return json;
    }
}
