package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.AreasInfo;
import org.springframework.stereotype.Component;

@Component
public interface AreasInfoMapper {
    int deleteByPrimaryKey(String areacode);

    int insert(AreasInfo record);

    int insertSelective(AreasInfo record);

    AreasInfo selectByPrimaryKey(String areacode);

    int updateByPrimaryKeySelective(AreasInfo record);

    int updateByPrimaryKey(AreasInfo record);
}