package com.sk.waternetwork.controller;

import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.config.ExcelData;
import com.sk.waternetwork.config.ExportExcelUtils;
import com.sk.waternetwork.model.JSONMessageView;
import com.sk.waternetwork.service.ReportFormService;
import com.sk.waternetwork.viewModel.*;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/6.
 */
@RestController
public class ReportFormController {
    @Autowired
    private ReportFormService reportFormService;

    /**
     * 实时数据报表
     */
    @RequestMapping(value = "/RealtimeReport", method = RequestMethod.POST)
    public JSONMessageView getRealtimeReport(@RequestBody RealtimeReportModel realtimeReportModel) {
        JSONMessageView json = new JSONMessageView();
        RealtimesPageModel rp = reportFormService.getRealtimeReport(realtimeReportModel);
        if (rp != null) {
            if (rp.getRlist().size() > 0) {
                json.setCode(0);
                json.setMessage("查询成功");
                json.setContent(rp);
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
     * 报表导出
     */
    @RequestMapping(value = "/excel", method = RequestMethod.POST)
    public void excel(HttpServletResponse response, @RequestBody ReportPrintModel reportPrintModel) throws Exception {
        List<RealtimesRetrunModel> rlist = reportFormService.getReportPrint(reportPrintModel);
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList<>();
        titles.add("时间");
        for(ParamViewModel pv :reportPrintModel.getParamlist()){
            titles.add(pv.getName());
        }
        /*titles.add("a1");
        titles.add("a2");
        titles.add("a3");*/
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        for (RealtimesRetrunModel rr : rlist){
            List<Object> row = new ArrayList();
            row.add(rr.getTime());
               for(RealtimeValueModel rv : rr.getDatalist()){
                   row.add(rv.getValue());
               }
            rows.add(row);
        }
        /*row.add("11111111111");
        row.add("22222222222");
        row.add("3333333333");
        rows.add(row);*/
        data.setRows(rows);
        //生成本地
        /*File f = new File("f:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExportExcelUtils.exportExcel(response, "设备实时数据报表2019/3/12.xlsx", data);
    }
}
