package com.sk.waternetwork.common;

import com.sk.waternetwork.mapper.WorkOrdersManageMapper.MyWorkOrdersMapper;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.RandomGUID;
import com.sk.waternetwork.model.WorkOrders;
import com.sk.waternetwork.service.WorkOrdersManageService.MyWorkOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Copyright by Xunge Software 2018. All right reserved
 *
 * @author YangWL
 * @date 2019/3/5 0005
 * @Description:
 */
public class All {
    @Autowired
    MyWorkOrdersService myWorkOrdersService;
    //新增工单
    //@RequestMapping(value = "/insertWorkOrders",method = RequestMethod.POST)
    public JSONMessageView insertWorkOrders( WorkOrders workOrders){

        JSONMessageView json=new JSONMessageView();
        workOrders.setCode(RandomGUID.createCode());
        workOrders.setCreatetime(new Date());



        try {
            int count  =myWorkOrdersService.insertWorkOrders(workOrders);
            if(count>0){
                json.setCode(1);
                json.setMessage("新增成功");
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
}
