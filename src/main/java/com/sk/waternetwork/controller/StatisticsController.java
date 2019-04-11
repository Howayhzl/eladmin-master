package com.sk.waternetwork.controller;

import com.sk.waternetwork.mapper.StatisticsMapper;
import com.sk.waternetwork.model.EquipmentParam;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.service.StatisticsService;
import com.sk.waternetwork.viewModel.StatisticsReturnModel;
import com.sk.waternetwork.viewModel.StatisticsViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2019/3/5.
 */
@RestController
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private StatisticsMapper statisticsMapper;
    /**
     * 统计分析
     */
    @RequestMapping(value = "/StatisticalAnalysis", method = RequestMethod.POST)
    public JSONMessageView getStatisticalAnalysis(@RequestBody StatisticsViewModel statisticsViewModel) {
        JSONMessageView json = new JSONMessageView();
        StatisticsReturnModel s = statisticsService.getDate(statisticsViewModel);
        if (s != null) {
            if (s.getDatalist().size()>0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(s);
            } else {
                json.setCode(-1);
                json.setMessage("查询失败");
            }
        } else {
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }
    /**
     * 获取参数列表
     */
    @RequestMapping(value = "/getParamlist", method = RequestMethod.GET)
    public JSONMessageView getParamlistByEquipmentCode(String code) {
        JSONMessageView json = new JSONMessageView();
        try {
            List<EquipmentParam> p = statisticsMapper.getParamlistByEquipmentCode(code);
            if(p.size()>0){
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(p);
            }else {
                json.setCode(-1);
                json.setMessage("查询失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            json.setCode(-10);
            json.setMessage("操作异常");
            return json;
        }
        return json;
    }
}
