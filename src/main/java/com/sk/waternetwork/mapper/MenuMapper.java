package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Menu;
import org.springframework.stereotype.Component;

@Component
public interface MenuMapper {
    int deleteByPrimaryKey(String menucode);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String menucode);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}