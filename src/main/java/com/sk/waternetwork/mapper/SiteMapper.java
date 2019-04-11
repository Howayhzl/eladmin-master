package com.sk.waternetwork.mapper;

import com.sk.waternetwork.model.*;
import com.sk.waternetwork.viewModel.AllEquimentViewModel;
import com.sk.waternetwork.viewModel.CreateNameViewModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public interface SiteMapper {
    int deleteByPrimaryKey(String code);

    int insert(Site record);

    int insertSelective(Site record);

    Site selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);

    public  List<Site> selectSiteByCompanyCode(@Param("companycode") String companycode);

   // public  List<AllEquimentViewModel> selectEquipmentByCompanyCode(@Param("companycode") String companycode);



   /* public     List<Waterpump> selectWaterpumpByCompanyCode(@Param("companycode") String companycode);
    public      List<Flowmeter>  selectFlowmeterByCompanyCode(@Param("companycode") String companycode);
    public      List<PipelineInformation>  selectPipelineInformationByCompanyCode(@Param("companycode") String companycode);
    public      List<Water>  selectWaterByCompanyCode(@Param("companycode") String companycode);
    public      List<Valve>  selectValveByCompanyCode(@Param("companycode") String companycode);
    public       List<WaterQuality> selectWaterQualityByCompanyCode(@Param("companycode") String companycode);*/



    //public  List<Site> selectSitePageByCompanyCode(@Param("companycode") String companycode);


}