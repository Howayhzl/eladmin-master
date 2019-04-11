package com.sk.waternetwork.controller;

import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.service.PrivilegeManageService;
import com.sk.waternetwork.viewModel.MenuIndewModel;
import com.sk.waternetwork.viewModel.MenulistViewModel;
import com.sk.waternetwork.viewModel.SaveRoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/3/20.
 */
@RestController
public class PrivilegeManageController {
    @Autowired
    private PrivilegeManageService privilegeManageService;
    /**
     * 查询角色菜单列表
     */
    @RequestMapping(value = "/getMenulistByRoleCode", method = RequestMethod.GET)
    public JSONMessageView getMenulistByRoleCode(String roleCode) {
        JSONMessageView json = new JSONMessageView();
        MenuIndewModel m = privilegeManageService.getMenulistByRoleCode(roleCode);
        if (m != null) {
            if (m.getMenulist().size() > 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(m);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败,该角色没有分配菜单");
            }
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }
    /**
     * 保存角色
     */
    @RequestMapping(value = "/saveRole", method = RequestMethod.POST)
    public JSONMessageView saveRole(@RequestBody SaveRoleViewModel saveRoleViewModel) {
        JSONMessageView json = new JSONMessageView();
        int count = privilegeManageService.saveRole(saveRoleViewModel);
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
