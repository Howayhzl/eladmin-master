package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Warning;
import org.springframework.stereotype.Component;

@Component
public interface WarningMapper {
    int deleteByPrimaryKey(String code);

    int insert(Warning record);

    int insertSelective(Warning record);

    Warning selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKey(Warning record);
}