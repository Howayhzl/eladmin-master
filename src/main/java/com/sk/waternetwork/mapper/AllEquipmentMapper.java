package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.*;
import com.sk.waternetwork.model.EquipmentParam;
import com.sk.waternetwork.viewModel.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Copyright by Xunge Software 2018. All right reserved
 *
 * @author YangWL
 * @date 2019/2/21 0021
 * @Description:
 */
@Component
public interface AllEquipmentMapper {

    public List<WaterQuality> selectWaterQualityByCompanyCode(@Param("companycode") String companycode);

    public List<Water> selectWaterByCompanyCode(@Param("companycode") String companycode);

    public List<Waterpump> selectWaterpumpByCompanyCode(@Param("companycode") String companycode);

    public List<Valve> selectValveByCompanyCode(@Param("companycode") String companycode);


    public List<Flowmeter> selectFlowmeterByCompanyCode(@Param("companycode") String companycode);

    public List<WaterpumpNameViewModel> selectWaterpumpByName(@Param("name") String name, @Param("companycode") String companycode);

    public List<WaterNameViewModel> selectWaterByName(@Param("name")String name, @Param("companycode") String companycode);

    public List<FlowmeterNameViewModel> selectFlowmeterByName(@Param("name")String name, @Param("companycode") String companycode);


    int deleteSiteAndEquipmentBySiteCode(String sitecode);
    int insertSiteAndEquipmentRelationship(@Param("list") List<SiteEquipmentRelationship> list);
    public  List<SiteEquipmentRelationship> selectBindEquipmentSiteBySiteCode(@Param("sitecode") String sitecode);

    int insertEquipmentParamByList(@Param("list")List<EquipmentParam> list);
    int deleteEquipmentParamByEquipmentCode(String equipmentcode);
    //int updateEquipmentParamByList(@Param("list")List<EquipmentParam> list);


    public  List<EquipmentParam> selectEquipmentParamByEquipment(String equipmentcode);


    int updateEquipmentParamByCode(@Param("list")List<String> list);

    int insertWaterpump(SaveWaterPumpParamViewModel saveWaterPumpParamViewModel);
    int updateWaterpump(SaveWaterPumpParamViewModel saveWaterPumpParamViewModel);

   // int insertEquipmentParamByList1(@Param("list")List<EquipmentParam> list);

    int insertWater(SaveWaterParamViewModel saveWaterParamViewModel);
    int updateWater(SaveWaterParamViewModel saveWaterParamViewModel );
    int insertFlowMeter(SaveFlowMeterParamViewModel saveFlowMeterParamViewModel );
    int updateFlowMeter(  SaveFlowMeterParamViewModel saveFlowMeterParamViewModel);


    //int deleteParamByEquipmentCode(String  equipmentcode);
    int deleteRelationshipByEquipmentCode(String  equipmentcode);
    int deleteWaterpump(String code);

    int deleteWater(String code);

    int deleteFlowmeter(String code);

}
