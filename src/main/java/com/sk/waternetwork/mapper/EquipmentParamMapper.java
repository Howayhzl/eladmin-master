package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.EquipmentParam;
import org.springframework.stereotype.Component;

@Component
public interface EquipmentParamMapper {
    int deleteByPrimaryKey(String code);

    int insert(EquipmentParam record);

    int insertSelective(EquipmentParam record);

    EquipmentParam selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(EquipmentParam record);

    int updateByPrimaryKey(EquipmentParam record);
}