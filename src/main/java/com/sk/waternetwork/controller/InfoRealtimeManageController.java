package com.sk.waternetwork.controller;

import com.sk.waternetwork.mapper.CompanyMapper;
import com.sk.waternetwork.mapper.InfoRealtimeManageMapper;
import com.sk.waternetwork.model.Company;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.viewModel.InfoRealtimeModel;
import com.sk.waternetwork.viewModel.IsSubsidiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/16.
 */
@RestController
public class InfoRealtimeManageController {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private InfoRealtimeManageMapper infoRealtimeManageMapper;

    @RequestMapping(value = "/selectInfo", method = RequestMethod.GET)
    public JSONMessageView getInfoByCode(String CompanyCode) {
        JSONMessageView json = new JSONMessageView();
        InfoRealtimeModel infoRealtimeModel = new InfoRealtimeModel();
        try {
            Company company = companyMapper.selectByPrimaryKey(CompanyCode);
            if(company!=null){
            infoRealtimeModel.setCompanyName(company.getName());
            List<Company> subsidiary =infoRealtimeManageMapper.getSubsidiaryByCompanyCode(CompanyCode);
            for(Company company1 : subsidiary) {
                IsSubsidiary isSubsidiary = new IsSubsidiary();
                isSubsidiary.setCompany(company1);
                List<Company> subsidiary1 =infoRealtimeManageMapper.getSubsidiaryByCompanyCode(company1.getCompanycode());
                if(subsidiary1.size()!=0){
                    isSubsidiary.setHave(true);
                }else {
                    isSubsidiary.setHave(false);
                }
                infoRealtimeModel.getSubsidiaryList().add(isSubsidiary);
            }
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(infoRealtimeModel);
            }else {
                json.setCode(-1);
                json.setMessage("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }
}
