package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleMapper {
    int deleteByPrimaryKey(String rolecode);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String rolecode);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}