package com.sk.waternetwork.controller.equipmentController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.mapper.AllEquipmentMapper;
import com.sk.waternetwork.mapper.WaterpumpMapper;
import com.sk.waternetwork.model.*;
import com.sk.waternetwork.service.equipmentService.EquipmentParamService;
import com.sk.waternetwork.service.equipmentService.WaterpumpService;
import com.sk.waternetwork.viewModel.SaveWaterPumpParamViewModel;
import org.apache.logging.log4j.core.jackson.ContextDataAsEntryListSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

/**
 * Copyright by Xunge Software 2018. All right reserved
 *
 * @author YangWL
 * @date 2019/2/15 0015
 * @Description:
 */
@RestController
public class WaterpumpController {
    @Autowired
    WaterpumpMapper waterpumpMapper;
    @Autowired
    WaterpumpService waterpumpService;
    @Autowired
    EquipmentParamService equipmentParamService;
@Autowired
    AllEquipmentMapper allEquipmentMapper;
    //根据名字查询水泵
    @RequestMapping(value = "/selectWaterpumpByName", method = RequestMethod.GET)
    public JSONMessageView selectWaterpumpByName(@RequestParam String name, @RequestParam String companycode, @RequestParam(defaultValue = "1") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer size) {
        JSONMessageView json = new JSONMessageView();
        PageInfo pageInfo = waterpumpService.selectWaterpumpByName(name, companycode, page, size);

        if (pageInfo != null) {
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


    //新增水泵
    @RequestMapping(value = "/insertWaterpump", method = RequestMethod.POST)
    public JSONMessageView insertWaterpump(@RequestBody Waterpump waterpump) {
        JSONMessageView json = new JSONMessageView();
        waterpump.setCode(RandomGUID.createCode());
        waterpump.setCreatetime(new Date());
        try {
            int count = waterpumpMapper.insertSelective(waterpump);

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

    //修改水泵
    @RequestMapping(value = "/updateWaterpump", method = RequestMethod.POST)
    public JSONMessageView updateWaterpump(@RequestBody Waterpump waterpump) {
        JSONMessageView json = new JSONMessageView();
        waterpump.setModifytime(new Date());
        try {
            int count = waterpumpMapper.updateByPrimaryKeySelective(waterpump);

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

    //删除水泵
    @RequestMapping(value = "/deleteWaterpump", method = RequestMethod.GET)
    public JSONMessageView deleteWaterpump(@RequestParam String code) {
        JSONMessageView json = new JSONMessageView();

            int count = waterpumpService.deleteWaterpump(code);
            if (count ==1) {
                json.setCode(0);
                json.setMessage("删除成功");
            }else {
                json.setCode(-10);
                json.setMessage("操作异常");
            }
        return json;


    }


    //新增水泵和水泵参数
    @RequestMapping(value = "/saveWaterPumpParam", method = RequestMethod.POST)
    public JSONMessageView saveWaterPumpParam(@RequestBody SaveWaterPumpParamViewModel saveWaterPumpParamViewModel) {
        JSONMessageView json = new JSONMessageView();

        int count = equipmentParamService.saveWaterPumpParam(saveWaterPumpParamViewModel);

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
