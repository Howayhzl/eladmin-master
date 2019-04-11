package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Users;
import org.springframework.stereotype.Component;

@Component
public interface UsersMapper {
    int deleteByPrimaryKey(String usercode);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String usercode);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}