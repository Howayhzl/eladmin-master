package com.sk.waternetwork.controller.WorkOrdersManageController;

import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.common.Message;
import com.sk.waternetwork.mapper.WorkOrdersManageMapper.MyWorkOrdersMapper;
import com.sk.waternetwork.mapper.WorkOrdersMapper;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.RandomGUID;
import com.sk.waternetwork.model.WorkOrders;
import com.sk.waternetwork.service.WorkOrdersManageService.MyWorkOrdersService;
import com.sk.waternetwork.viewModel.CloseWorkOrdersViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Administrator on 2019/2/18.
 */
@RestController
public class MyWorkOrdersController {
    @Autowired
    private MyWorkOrdersService myWorkOrdersService;
    @Autowired
    private MyWorkOrdersMapper myWorkOrdersMapper;
    @Autowired
    private WorkOrdersMapper workOrdersMapper;

    /**
     * 查询工单
     */
    @RequestMapping(value = "/selectWorkOrders", method = RequestMethod.GET)
    public JSONMessageView selectWorkOrdersByState(@RequestParam String userCode, @RequestParam String companyCode, @RequestParam Integer state, @RequestParam(defaultValue = "1") Integer page,
                                                   @RequestParam(defaultValue = "10") Integer size) {
        JSONMessageView json = new JSONMessageView();
        PageInfo pageInfo = myWorkOrdersService.selectWorkOrdersByState(userCode, companyCode, state, page, size);
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
     * 关闭打开工单
     */
    @RequestMapping(value = "/closeWorkOrders", method = RequestMethod.POST)
    public JSONMessageView closeWorkOrders(@RequestBody CloseWorkOrdersViewModel closeWorkOrdersViewModel) {
        JSONMessageView json = new JSONMessageView();
        try {
            int count = myWorkOrdersMapper.closeWorkOrders(closeWorkOrdersViewModel);
            if (count > 0) {
                json.setCode(0);
                if(closeWorkOrdersViewModel.getState()==0){
                    json.setMessage("关闭成功");
                }else {
                    json.setMessage("打开成功");
                }
            } else {
                json.setCode(-1);
                if(closeWorkOrdersViewModel.getState()==0){
                    json.setMessage("关闭失败");
                }else {
                    json.setMessage("打开失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }



    //新增工单
    @RequestMapping(value = "/insertWorkOrders",method = RequestMethod.POST)
    public JSONMessageView insertWorkOrders(@RequestBody WorkOrders workOrders){

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


    //发送短信接口


}
