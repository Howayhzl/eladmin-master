package com.sk.waternetwork.controller;

import com.sk.waternetwork.mapper.CompanyMapper;
import com.sk.waternetwork.mapper.TestMapper;
import com.sk.waternetwork.model.Company;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.service.TestService;
import com.sk.waternetwork.viewModel.RealtimeRetrunModel;
import com.sk.waternetwork.viewModel.RealtimeViewModel;
import com.sk.waternetwork.viewModel.SelectRealtimeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private TestMapper testMapper;
    Integer count = 1;

    /**
     * @return java.lang.String 出参实时数据json串
     * @Author jingqi
     * @Description 根据该公司编号查询所有子公司编号
     * @Date 2019/01/09
     * @Param String ConpanyCode
     **/
    @RequestMapping(value = "/select3", method = RequestMethod.GET)
    public JSONMessageView getSubsidiaryByCompanyCode(String CompanyCode) {
        JSONMessageView json = new JSONMessageView();
        List<Company> list1 = new ArrayList<Company>();//变量，每次查询的子公司集合
        List<Company> list2 = new ArrayList<Company>();//增量，所有子公司集合
        try {
            Company company = companyMapper.selectByPrimaryKey(CompanyCode);
            if(company != null){
                list1.add(company);
                list2.add(company);
                list1 = testMapper.getSubsidiaryByCompany(list1);
                    while (list1.size()!=0) {
                        list2.addAll(list1);
                        list1 = testMapper.getSubsidiaryByCompany(list1);
                    }
                    json.setCode(0);
                    json.setMessage("查询成功");
                    json.setContent(list2);
            }else{
                json.setCode(-1);
                json.setMessage("查询失败,该公司不存在");
            }
        }catch (Exception e){
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/select4", method = RequestMethod.GET)
    public JSONMessageView testRedis() {

        return null;
     }


}
