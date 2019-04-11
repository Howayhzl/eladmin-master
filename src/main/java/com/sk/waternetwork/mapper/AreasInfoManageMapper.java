package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.AreasInfo;
import com.sk.waternetwork.model.AreasSiteRelationship;
import com.sk.waternetwork.model.Site;
import com.sk.waternetwork.viewModel.SaveAreasViewModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/2/13.
 */
@Component
public interface AreasInfoManageMapper {
    int deleteAreasSiteRelationshipByAreaCode(String code);
    int deleteAreasSiteRelationshipByAreaCodes(@Param("list")List<String> list);
    List<Site> selectAreasSiteByAreaCode(String code);
    List<AreasInfo> selectAreasByParentNode(String code);
    int insertAreasSiteRelationship(@Param("list")List<AreasSiteRelationship>  list);
    List<String> getAreaCodeByParentNode(@Param("list")List<String> list);
    int deleteAreasByAreaCode(@Param("list")List<String> list);
    int insertAreas(SaveAreasViewModel saveAreasViewModel);
    int updateAreas(SaveAreasViewModel saveAreasViewModel);
}
