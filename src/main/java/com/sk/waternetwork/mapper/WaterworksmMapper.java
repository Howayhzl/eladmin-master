package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Waterworks;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/3/26.
 */
@Component
public interface WaterworksmMapper {
    List<Waterworks> getWaterworksByCompanyCode(String CompanyCode);
    List<Waterworks> selectWaterworksByCondition(Waterworks waterworks);
}
