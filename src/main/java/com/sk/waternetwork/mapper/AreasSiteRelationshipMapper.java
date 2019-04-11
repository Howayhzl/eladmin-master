package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.AreasSiteRelationship;
import org.springframework.stereotype.Component;

@Component
public interface AreasSiteRelationshipMapper {
    int deleteByPrimaryKey(String code);

    int insert(AreasSiteRelationship record);

    int insertSelective(AreasSiteRelationship record);

    AreasSiteRelationship selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(AreasSiteRelationship record);

    int updateByPrimaryKey(AreasSiteRelationship record);
}