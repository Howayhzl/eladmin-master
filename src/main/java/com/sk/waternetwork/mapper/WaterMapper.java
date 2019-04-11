package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Water;
import org.springframework.stereotype.Component;

@Component
public interface WaterMapper {
    int deleteByPrimaryKey(String code);

    int insert(Water record);

    int insertSelective(Water record);

    Water selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Water record);

    int updateByPrimaryKey(Water record);
}