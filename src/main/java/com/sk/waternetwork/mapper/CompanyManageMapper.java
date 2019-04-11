package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/1/15.
 */
@Component
public interface CompanyManageMapper {
    List<Company> getSubsidiaryByCompany(@Param("list")List<Company>  list);
}
