package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Company;
import org.springframework.stereotype.Component;

@Component
public interface CompanyMapper {
    int deleteByPrimaryKey(String companycode);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String companycode);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}