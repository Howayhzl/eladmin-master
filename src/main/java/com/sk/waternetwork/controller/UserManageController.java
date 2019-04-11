package com.sk.waternetwork.controller;

import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.mapper.UsersMapper;
import com.sk.waternetwork.mapper.UserManageMapper;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.Users;
import com.sk.waternetwork.model.RandomGUID;
import com.sk.waternetwork.model.UtilMD5;
import com.sk.waternetwork.service.UserManageService;
import com.sk.waternetwork.viewModel.SelectUserModel;
import com.sk.waternetwork.viewModel.UpdatePasswordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.Date;

@Api(description = "用户管理")
@RestController
public class UserManageController {
    @Autowired
    private UserManageMapper userManageMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserManageService userManageService;

    /**
     * 查询所有用户接口
     */
    @ApiOperation("查询所有用户接口")
    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    public JSONMessageView getAllUser(@RequestParam String CompanyCode, @RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "10") Integer size) {
        JSONMessageView json = new JSONMessageView();

        //List<Users> list = userManageMapper.selectAllUser(CompanyCode);
        PageInfo pageInfo = userManageService.selectAllUser(CompanyCode, page, size);
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
     * 用户添加接口
     */
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public JSONMessageView insertUser(@RequestBody Users users) {
        JSONMessageView json = new JSONMessageView();
        users.setUsercode(RandomGUID.createCode());
        String password = UtilMD5.getdata(users.getPassword());
        users.setPassword(password);
        users.setCreatetime(new Date());
        try {
            int count = usersMapper.insertSelective(users);
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

    /**
     * 删除用户接口
     */
    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "用户编码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public JSONMessageView deleteUserByCode(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            int count = usersMapper.deleteByPrimaryKey(code);
            if (count > 0) {
                json.setCode(0);
                json.setMessage("删除成功");
            } else {
                json.setCode(-1);
                json.setMessage("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    /**
     * 用户修改接口
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public JSONMessageView updateUser(@RequestBody Users users) {
        JSONMessageView json = new JSONMessageView();
        users.setModifytime(new Date());
        try {
            int count = usersMapper.updateByPrimaryKeySelective(users);
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

    //修改密码
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public JSONMessageView updatePassword(@RequestBody UpdatePasswordModel updatePasswordModel) {
        JSONMessageView json = new JSONMessageView();
        try {
            updatePasswordModel.setPassword(UtilMD5.getdata(updatePasswordModel.getPassword()));
            String password = usersMapper.selectByPrimaryKey(updatePasswordModel.getCode()).getPassword();
            if (updatePasswordModel.getPassword().equals(password)) {
                updatePasswordModel.setNewPassword(UtilMD5.getdata(updatePasswordModel.getNewPassword()));
                int count = userManageMapper.updatePassword(updatePasswordModel);
                if (count > 0) {
                    json.setCode(0);
                    json.setMessage("密码修改成功");
                } else {
                    json.setCode(-1);
                    json.setMessage("密码修改失败");
                }
            } else {
                json.setCode(-2);
                json.setMessage("原密码输入错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    //管理员重置密码
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public JSONMessageView resetPassword(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            int count = userManageMapper.resetPassword(code);
            if (count > 0) {
                json.setCode(0);
                json.setMessage("密码重置成功");
            } else {
                json.setCode(-1);
                json.setMessage("密码重置失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    //多条件查询
    @RequestMapping(value = "/selectUserByCondition", method = RequestMethod.POST)
    public JSONMessageView selectUserByCondition(@RequestBody SelectUserModel selectUserModel) {
        JSONMessageView json = new JSONMessageView();
        //List<Users> list = userManageMapper.selectUserByCondition(users);
        PageInfo pageInfo = userManageService.selectUserByCondition(selectUserModel);
        if (pageInfo.getList() != null) {
            if (pageInfo.getList().size() != 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(pageInfo);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败,没有符合条件的结果");
            }
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
        }
        return json;
    }
}
