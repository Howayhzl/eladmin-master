package com.sk.waternetwork.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/1/23.
 */
@Component
public interface DeviceManageMapper {
    String getAreaCodeByCondition(@Param("CompanyCode")String CompanyCode,@Param("address")String address);
}
