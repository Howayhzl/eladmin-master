package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Waterworks;
import org.springframework.stereotype.Component;

@Component
public interface WaterworksMapper {
    int deleteByPrimaryKey(String code);

    int insert(Waterworks record);

    int insertSelective(Waterworks record);

    Waterworks selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Waterworks record);

    int updateByPrimaryKey(Waterworks record);
}