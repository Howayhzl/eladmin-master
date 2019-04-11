package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Users;
import com.sk.waternetwork.viewModel.UpdatePasswordModel;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserManageMapper {
    List<Users> selectAllUser(String CompanyCode);
    int updatePassword(UpdatePasswordModel updatePasswordModel);
    int resetPassword(String code);
    List<Users> selectUserByCondition(Users users);
}
