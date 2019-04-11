package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface LoginMapper {
    Users selectBypassword(@Param("usernames") String usernames, @Param("password")String password);
}
