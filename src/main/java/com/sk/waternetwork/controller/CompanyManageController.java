package com.sk.waternetwork.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.mapper.CompanyManageMapper;
import com.sk.waternetwork.mapper.CompanyMapper;
import com.sk.waternetwork.mapper.InfoRealtimeManageMapper;
import com.sk.waternetwork.model.Company;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.model.RandomGUID;
import com.sk.waternetwork.viewModel.CompanyListViewModel;
import com.sk.waternetwork.viewModel.ConditionCompanyModel;
import com.sk.waternetwork.viewModel.SelectCompanyModel;
import com.sk.waternetwork.viewModel.SubsidiaryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/1/15.
 */
@RestController
public class CompanyManageController {
    @Autowired
    private CompanyManageMapper companyManageMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private InfoRealtimeManageMapper infoRealtimeManageMapper;
    /*@RequestMapping(value = "/selectCompany", method = RequestMethod.GET)
    public JSONMessageView getSubsidiaryByCompanyCode(@RequestParam String CompanyCode,@RequestParam(defaultValue = "1") Integer page,
                                                      @RequestParam(defaultValue = "10") Integer size) {
        JSONMessageView json = new JSONMessageView();
        List<Company> list1 = new ArrayList<Company>();//变量，每次查询的子公司集合
        List<Company> list2 = new ArrayList<Company>();//增量，所有子公司集合
        try {
            Company company = companyMapper.selectByPrimaryKey(CompanyCode);//查询本公司
            if(company != null){
                Company company1 = companyMapper.selectByPrimaryKey(company.getParentcode());//查询父公司
                if(company1!= null){
                    list2.add(company1);
                }
                list1.add(company);
                list2.add(company);
                list1 = companyManageMapper.getSubsidiaryByCompany(list1);//查询所有子公司
                while (list1.size()!=0) {
                    list2.addAll(list1);
                    list1 = companyManageMapper.getSubsidiaryByCompany(list1);
                }
                json.setCode(0);
                json.setMessage("查询成功");
//                PageHelper.startPage(page, size);
//                PageInfo pageInfo = new PageInfo<>(list2);
//                json.setContent(pageInfo);
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
    }*/

    /**
     * 本公司及所有子公司列表查询
     */
    @RequestMapping(value = "/selectCompanyList", method = RequestMethod.GET)
    public JSONMessageView getCompanyListByCompanyCode(@RequestParam String CompanyCode) {
        JSONMessageView json = new JSONMessageView();
        List<Company> list1 = new ArrayList<Company>();//变量，每次查询的子公司集合
        List<Company> list2 = new ArrayList<Company>();//增量，所有子公司集合
        try {
            Company company = companyMapper.selectByPrimaryKey(CompanyCode);//查询本公司
            if (company != null) {
                /*Company company1 = companyMapper.selectByPrimaryKey(company.getParentcode());//查询父公司
                if(company1!= null){
                    list2.add(company1);
                }*/
                list1.add(company);
                list2.add(company);
                list1 = companyManageMapper.getSubsidiaryByCompany(list1);//查询所有子公司
                while (list1.size() != 0) {
                    list2.addAll(list1);
                    list1 = companyManageMapper.getSubsidiaryByCompany(list1);
                }
                List<CompanyListViewModel> companyListViewModelList = new ArrayList<CompanyListViewModel>();
                for (Company company1 : list2) {
                    CompanyListViewModel companyListViewModel = new CompanyListViewModel();
                    companyListViewModel.setCode(company1.getCompanycode());
                    companyListViewModel.setName(company1.getName());
                    companyListViewModelList.add(companyListViewModel);
                }
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(companyListViewModelList);
            } else {
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

    @RequestMapping(value = "/selectCompany", method = RequestMethod.GET)
    public JSONMessageView getSubsidiaryByCompanyCode(@RequestParam String CompanyCode) {
        JSONMessageView json = new JSONMessageView();
        SelectCompanyModel selectCompanyModel = new SelectCompanyModel();
        try {
            Company company = companyMapper.selectByPrimaryKey(CompanyCode);
            if (company != null) {
                selectCompanyModel.setCompany(company);
                List<Company> subsidiary = infoRealtimeManageMapper.getSubsidiaryByCompanyCode(CompanyCode);
                for (Company company1 : subsidiary) {
                    SubsidiaryViewModel subsidiaryViewModel = new SubsidiaryViewModel();
                    subsidiaryViewModel.setName(company1.getName());
                    subsidiaryViewModel.setCode(company1.getCompanycode());
                    List<Company> subsidiary1 = infoRealtimeManageMapper.getSubsidiaryByCompanyCode(company1.getCompanycode());
                    if (subsidiary1.size() != 0) {
                        subsidiaryViewModel.setHave(true);
                    } else {
                        subsidiaryViewModel.setHave(false);
                    }
                    selectCompanyModel.getSubsidiaryViewModelList().add(subsidiaryViewModel);
                }
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(selectCompanyModel);
            } else {
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

    @RequestMapping(value = "/selectCompanyByCondition", method = RequestMethod.POST)
    public JSONMessageView getCompanyByCondition(@RequestBody ConditionCompanyModel conditionCompanyModel) {
        JSONMessageView json = new JSONMessageView();
        List<Company> list1 = new ArrayList<Company>();//变量，每次查询的子公司集合
        List<Company> list2 = new ArrayList<Company>();//增量，所有子公司集合
        try {
            Company company = companyMapper.selectByPrimaryKey(conditionCompanyModel.getCompany().getCompanycode());//查询本公司
            if (company != null) {
                list1.add(company);
                list2.add(company);
                list1 = companyManageMapper.getSubsidiaryByCompany(list1);//查询所有子公司
                while (list1.size() != 0) {
                    list2.addAll(list1);
                    list1 = companyManageMapper.getSubsidiaryByCompany(list1);
                }

                json.setCode(0);
                json.setMessage("查询成功");
//                PageHelper.startPage(page, size);
//                PageInfo pageInfo = new PageInfo<>(list2);
//                json.setContent(pageInfo);
                json.setContent(list2);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败,该公司不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    @RequestMapping(value = "/insertCompany", method = RequestMethod.POST)
    public JSONMessageView insertCompany(@RequestBody Company company) {
        JSONMessageView json = new JSONMessageView();
        company.setCompanycode(RandomGUID.createCode());
        company.setCreatetime(new Date());
        if (company.getParentcode() == null) {
            company.setParentcode("");
        }
        try {
            int count = companyMapper.insertSelective(company);
            if (count > 0) {
                json.setCode(0);
                json.setMessage("增添成功");
            } else {
                json.setCode(-1);
                json.setMessage("增添失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    @RequestMapping(value = "/deleteCompany", method = RequestMethod.GET)
    public JSONMessageView deleteCompanyByCode(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            int count = companyMapper.deleteByPrimaryKey(code);
            if (count > 0) {
                json.setCode(0);
                json.setMessage("删除成功");
            } else {
                json.setCode(-1);
                json.setMessage("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }

    @RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
    public JSONMessageView updateCompany(@RequestBody Company company) {
        JSONMessageView json = new JSONMessageView();
        company.setModifytime(new Date());
        try {
            int count = companyMapper.updateByPrimaryKeySelective(company);
            if (count > 0) {
                json.setCode(0);
                json.setMessage("修改成功");
            } else {
                json.setCode(-1);
                json.setMessage("修改失败");
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
