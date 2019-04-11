package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.SiteEquipmentRelationship;
import org.springframework.stereotype.Component;

@Component
public interface SiteEquipmentRelationshipMapper {
    int deleteByPrimaryKey(String code);

    int insert(SiteEquipmentRelationship record);

    int insertSelective(SiteEquipmentRelationship record);

    SiteEquipmentRelationship selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SiteEquipmentRelationship record);

    int updateByPrimaryKey(SiteEquipmentRelationship record);
}