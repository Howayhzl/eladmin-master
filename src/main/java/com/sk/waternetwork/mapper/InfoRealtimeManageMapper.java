package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Company;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/1/16.
 */
@Component
public interface InfoRealtimeManageMapper {
    List<Company> getSubsidiaryByCompanyCode(String code);
}
