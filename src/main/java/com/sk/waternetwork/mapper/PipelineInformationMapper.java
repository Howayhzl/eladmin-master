package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.PipelineInformation;
import com.sk.waternetwork.model.Valve;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PipelineInformationMapper {
    int deleteByPrimaryKey(String code);

    int insert(PipelineInformation record);

    int insertSelective(PipelineInformation record);

    PipelineInformation selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(PipelineInformation record);

    int updateByPrimaryKey(PipelineInformation record);


}