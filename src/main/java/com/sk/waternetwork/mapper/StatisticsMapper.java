package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.EquipmentParam;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/3/6.
 */
@Component
public interface StatisticsMapper {
    List<EquipmentParam> getParamlistByEquipmentCode(String code);

}
