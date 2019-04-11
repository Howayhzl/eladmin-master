package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Waterpump;
import org.springframework.stereotype.Component;

@Component
public interface WaterpumpMapper {
    int deleteByPrimaryKey(String code);

    int insert(Waterpump record);

    int insertSelective(Waterpump record);

    Waterpump selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Waterpump record);

    int updateByPrimaryKey(Waterpump record);
}