package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.RoleMenuRelationship;
import org.springframework.stereotype.Component;

@Component
public interface RoleMenuRelationshipMapper {
    int deleteByPrimaryKey(String code);

    int insert(RoleMenuRelationship record);

    int insertSelective(RoleMenuRelationship record);

    RoleMenuRelationship selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(RoleMenuRelationship record);

    int updateByPrimaryKey(RoleMenuRelationship record);
}