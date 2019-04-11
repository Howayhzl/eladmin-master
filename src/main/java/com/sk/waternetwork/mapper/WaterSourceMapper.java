package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.WaterSource;
import org.springframework.stereotype.Component;

@Component
public interface WaterSourceMapper {
    int deleteByPrimaryKey(String code);

    int insert(WaterSource record);

    int insertSelective(WaterSource record);

    WaterSource selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(WaterSource record);

    int updateByPrimaryKey(WaterSource record);
}