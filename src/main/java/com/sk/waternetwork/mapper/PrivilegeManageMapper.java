package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.Menu;
import com.sk.waternetwork.viewModel.SaveRoleViewModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/3/20.
 */
@Component
public interface PrivilegeManageMapper {
    List<String> getMenuCodeByRoleCode(String code);

    List<Menu> getMenulistByMenuCode(@Param("list") List<String> list);

    List<Menu> getMenulistByParentCode(@Param("code") String code, @Param("list") List<String> list);

    List<String> getIndexlistByMenuCode(@Param("list") List<String> list);
    int insertRole(SaveRoleViewModel saveRoleViewModel);
}
