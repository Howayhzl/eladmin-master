package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.WaterSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/3/26.
 */
@Component
public interface WaterSourcemMapper {
    List<WaterSource> getWaterSourceByCompanyCode(String CompanyCode);
    List<WaterSource> selectWaterSourceByCondition(WaterSource waterSource);
}
