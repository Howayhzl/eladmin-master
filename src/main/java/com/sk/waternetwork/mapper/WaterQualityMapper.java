package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.WaterQuality;
import org.springframework.stereotype.Component;

@Component
public interface WaterQualityMapper {
    int deleteByPrimaryKey(String code);

    int insert(WaterQuality record);

    int insertSelective(WaterQuality record);

    WaterQuality selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(WaterQuality record);

    int updateByPrimaryKey(WaterQuality record);
}