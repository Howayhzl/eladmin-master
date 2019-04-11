package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.*;
import com.sk.waternetwork.viewModel.FlowmeterRealtimeModel;
import com.sk.waternetwork.viewModel.RealtimeViewModel;
import com.sk.waternetwork.viewModel.WaterRealtimeModel;
import com.sk.waternetwork.viewModel.WaterpumpRealtimeModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/2/12.
 */
@Component
public interface HomeMapper {
    List<PipelineInformation> getPipelineByCompanyCode(String code);
    List<AreasInfo> getAreasByCompanyCode(String code);
    List<SiteEquipmentRelationship> getSiteEquipmentRelationshipBySiteCode(String code);
    WaterpumpRealtimeModel getWaterpumpRealtimeModelByCode(String code);
    WaterRealtimeModel getWaterRealtimeModelByCode(String code);
    FlowmeterRealtimeModel getFlowmeterRealtimeModelByCode(String code);
    Site getSiteByCode(@Param("code")String code,@Param("companyCode")String companyCode);
    List<EquipmentParam> getEquipmentParamByEquipmentCode(String code);
    int insertWarning(@Param("list")List<Warning> list);
    List<Warning> getWarningByCompanyCode(String code);
    List<Warning> getWarninglistByCompanyCode(String code);
    int getCountByCompanyCode(String code);
    List<String> getPipeDiameterByCompanyCode(String companyCode);
}
