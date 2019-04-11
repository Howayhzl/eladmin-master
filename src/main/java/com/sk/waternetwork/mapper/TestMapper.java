package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestMapper {

    List<Company> getSubsidiaryByCompany(@Param("list")List<Company>  list);

    //RealtimeParameter getWaterpumpDate(String code);
}
