package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Flowmeter;
import org.springframework.stereotype.Component;

@Component
public interface FlowmeterMapper {
    int deleteByPrimaryKey(String code);

    int insert(Flowmeter record);

    int insertSelective(Flowmeter record);

    Flowmeter selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Flowmeter record);

    int updateByPrimaryKey(Flowmeter record);
}