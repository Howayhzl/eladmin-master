package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Valve;
import org.springframework.stereotype.Component;

@Component
public interface ValveMapper {
    int deleteByPrimaryKey(String code);

    int insert(Valve record);

    int insertSelective(Valve record);

    Valve selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Valve record);

    int updateByPrimaryKey(Valve record);
}