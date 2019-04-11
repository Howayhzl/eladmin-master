package com.sk.waternetwork.controller;

import com.sk.waternetwork.mapper.LoginMapper;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.Users;
import com.sk.waternetwork.model.UtilMD5;
import com.sk.waternetwork.viewModel.LoginViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StartController {
    @Autowired
    private LoginMapper loginMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONMessageView login(@RequestBody LoginViewModel loginViewModel) {
        JSONMessageView json = new JSONMessageView();
        String password = UtilMD5.getdata(loginViewModel.getPassWord());
        try {
            Users users = loginMapper.selectBypassword(loginViewModel.getUserName(),password);
            if(users !=null){
                json.setCode(0);
                json.setMessage("登录成功");
                json.setContent(users);
            }else {
                json.setCode(-1);
                json.setMessage("登录失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("登录异常");
            return json;
        }
        return json;
    }
}
