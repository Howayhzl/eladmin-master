package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.WorkOrders;
import org.springframework.stereotype.Component;

@Component
public interface WorkOrdersMapper {
    int deleteByPrimaryKey(String code);

    int insert(WorkOrders record);

    int insertSelective(WorkOrders record);

    WorkOrders selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(WorkOrders record);

    int updateByPrimaryKey(WorkOrders record);
}