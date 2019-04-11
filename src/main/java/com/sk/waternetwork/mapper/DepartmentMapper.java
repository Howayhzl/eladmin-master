package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Department;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentcode);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentcode);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}