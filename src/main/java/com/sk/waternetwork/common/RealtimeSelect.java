package com.sk.waternetwork.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sk.waternetwork.viewModel.*;
import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Administrator on 2019/2/25.
 */
public class RealtimeSelect {
    public static RealtimesViewModel getWaterpumpRealtimeByCode(String deviceCode, String companyCode) {
        RealtimesViewModel rss = new RealtimesViewModel();
        List<RealtimeViewModel> rlist = new ArrayList<>();
        switch (companyCode) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql = "select top 1 DQSDYL,JSKYL,CSKYL,Date from WaterPumpInfo_ZA where DeviceID = ? order by Date desc";
                    PreparedStatement p = con.prepareStatement(sql);
                    int i = 1;
                    p.setString(i, deviceCode);
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeViewModel item = new RealtimeViewModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rlist.add(item);
                        }
                        rss.setWarningTime(rs.getDate(4));
                    }
                    rss.setRlist(rlist);
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rss;
    }

    public static RealtimesViewModel getWaterRealtimeByCode(String deviceCode, String companyCode) {
        RealtimesViewModel rss = new RealtimesViewModel();
        List<RealtimeViewModel> rlist = new ArrayList<>();
        switch (companyCode) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql = "select top 1 CURR_WORD,VOLTAGE,SIGNAL_STR,PRESSURE1,TOTAL_NUM,REMAIN_NUM,POSITIVE_SUM,NEGATIVE_SUM,FLOW_VEL,CREATE_DATE from METER_READ_LIST where SIM_ID = ? order by CREATE_DATE desc";
                    PreparedStatement p = con.prepareStatement(sql);
                    int i = 1;
                    p.setString(i, deviceCode);
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeViewModel item = new RealtimeViewModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rlist.add(item);
                        }
                        rss.setWarningTime(rs.getDate(10));
                    }
                    rss.setRlist(rlist);
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rss;
    }

    public static RealtimesViewModel getFlowmeterRealtimeByCode(String deviceCode, String companyCode) {
        RealtimesViewModel rss = new RealtimesViewModel();
        List<RealtimeViewModel> rlist = new ArrayList<>();
        switch (companyCode) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql = "select top 1 PlusTotalFlux,ReverseTotalFlux,Flux,JLDY,TXDY,readtime from DX_DataFlow where fmaddress = ? order by readtime desc";
                    PreparedStatement p = con.prepareStatement(sql);
                    int i = 1;
                    p.setString(i, deviceCode);
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeViewModel item = new RealtimeViewModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rlist.add(item);
                        }
                        rss.setWarningTime(rs.getDate(6));
                    }
                    rss.setRlist(rlist);
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rss;
    }

    public static StatisticsReturnModel getWaterpumpParam(StatisticsViewModel s) {
        StatisticsReturnModel sr = new StatisticsReturnModel();
        List<StatisticsDataModel> sdlist = new ArrayList<>();
        switch (s.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String str = s.getParam();
                    String sql = "  select " + str + " ,Date from WaterPumpInfo_ZA where DeviceID = ? and Date between ? and ? order by Date asc";
                    PreparedStatement p = con.prepareStatement(sql);
                    p.setString(1, s.getDeviceCode());
                    java.sql.Timestamp startTime = new java.sql.Timestamp(s.getStartTime().getTime());
                    p.setTimestamp(2,startTime);
                    java.sql.Timestamp endTime = new java.sql.Timestamp(s.getEndTime().getTime());
                    p.setTimestamp(3,endTime);
                    ResultSet rs = p.executeQuery();
                    while (rs.next()) {
                        StatisticsDataModel sd = new StatisticsDataModel();
                        sd.setValue(rs.getString(1));
                        sd.setTime(rs.getTimestamp(2));
                        sdlist.add(sd);
                    }
                    sr.setDatalist(sdlist);
                    String sql1 = "select MAX(" + str + "),MIN(" + str + "),ROUND(AVG(cast(" + str + "  as float)),2) from WaterPumpInfo_ZA where DeviceID = ? and Date between ? and ? ";
                    PreparedStatement p1 = con.prepareStatement(sql1);
                    p1.setString(1, s.getDeviceCode());
                    p1.setTimestamp(2, startTime);
                    p1.setTimestamp(3, endTime);
                    ResultSet rs1 = p1.executeQuery();
                    while (rs1.next()) {
                        sr.setMax(rs1.getString(1));
                        sr.setMin(rs1.getString(2));
                        sr.setAvg(rs1.getString(3));
                    }
                    rs1.close();
                    p1.close();
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return sr;
    }

    public static StatisticsReturnModel getWaterParam(StatisticsViewModel s) {
        StatisticsReturnModel sr = new StatisticsReturnModel();
        List<StatisticsDataModel> sdlist = new ArrayList<>();
        switch (s.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String str = s.getParam();
                    String sql = "  select " + str + " ,CREATE_DATE from METER_READ_LIST where SIM_ID = ? and CREATE_DATE between ? and ? order by CREATE_DATE asc";
                    PreparedStatement p = con.prepareStatement(sql);
                    p.setString(1, s.getDeviceCode());
                    java.sql.Timestamp startTime = new java.sql.Timestamp(s.getStartTime().getTime());
                    p.setTimestamp(2, startTime);
                    java.sql.Timestamp endTime = new java.sql.Timestamp(s.getEndTime().getTime());
                    p.setTimestamp(3, endTime);
                    ResultSet rs = p.executeQuery();
                    while (rs.next()) {
                        StatisticsDataModel sd = new StatisticsDataModel();
                        sd.setValue(rs.getString(1));
                        sd.setTime(rs.getTimestamp(2));
                        sdlist.add(sd);
                    }
                    sr.setDatalist(sdlist);
                    String sql1 = "select MAX(" + str + "),MIN(" + str + "),ROUND(AVG(cast(" + str + "  as float)),2) from METER_READ_LIST where SIM_ID = ? and CREATE_DATE between ? and ?";
                    PreparedStatement p1 = con.prepareStatement(sql1);
                    p1.setString(1, s.getDeviceCode());
                    p1.setTimestamp(2, startTime);
                    p1.setTimestamp(3, endTime);
                    ResultSet rs1 = p1.executeQuery();
                    while (rs1.next()) {
                        sr.setMax(rs1.getString(1));
                        sr.setMin(rs1.getString(2));
                        sr.setAvg(rs1.getString(3));
                    }
                    rs1.close();
                    p1.close();
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return sr;
    }

    public static StatisticsReturnModel getFlowmeterParam(StatisticsViewModel s) {
        StatisticsReturnModel sr = new StatisticsReturnModel();
        List<StatisticsDataModel> sdlist = new ArrayList<>();
        switch (s.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String str = s.getParam();
                    String sql = "  select " + str + " ,readtime from DX_DataFlow where fmaddress = ? and readtime between ? and ? order by readtime asc";
                    PreparedStatement p = con.prepareStatement(sql);
                    p.setString(1, s.getDeviceCode());
                    java.sql.Timestamp startTime = new java.sql.Timestamp(s.getStartTime().getTime());
                    p.setTimestamp(2, startTime);
                    java.sql.Timestamp endTime = new java.sql.Timestamp(s.getEndTime().getTime());
                    p.setTimestamp(3, endTime);
                    ResultSet rs = p.executeQuery();
                    while (rs.next()) {
                        StatisticsDataModel sd = new StatisticsDataModel();
                        sd.setValue(rs.getString(1));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = sdf.parse(rs.getString(2) + ":00");
                        sd.setTime(date);
                        sdlist.add(sd);
                    }
                    sr.setDatalist(sdlist);
                    String sql1 = "select MAX(" + str + "),MIN(" + str + "),ROUND(AVG(cast(" + str + "  as float)),2) from DX_DataFlow where fmaddress = ? and readtime between ? and ?";
                    PreparedStatement p1 = con.prepareStatement(sql1);
                    p1.setString(1, s.getDeviceCode());
                    p1.setTimestamp(2, startTime);
                    p1.setTimestamp(3, endTime);
                    ResultSet rs1 = p1.executeQuery();
                    while (rs1.next()) {
                        sr.setMax(rs1.getString(1));
                        sr.setMin(rs1.getString(2));
                        sr.setAvg(rs1.getString(3));
                    }
                    rs1.close();
                    p1.close();
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return sr;
    }
    public static RealtimesPageModel getWaterpumpReport(RealtimeReportModel r) {
        RealtimesPageModel rp = new RealtimesPageModel();
        List<RealtimesRetrunModel> rlist = new ArrayList<>();
        Page page =null;
        switch (r.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql1 = "select COUNT(DeviceID) from WaterPumpInfo_ZA where DeviceID = ? and Date between ? and ?";
                    PreparedStatement p1 = con.prepareStatement(sql1);
                    p1.setString(1, r.getDeviceCode());
                    java.sql.Timestamp startTime = new java.sql.Timestamp(r.getStartTime().getTime());
                    int i =2;
                    p1.setTimestamp(i, startTime);
                    java.sql.Timestamp endTime = new java.sql.Timestamp(r.getEndTime().getTime());
                    p1.setTimestamp(i+1, endTime);
                    ResultSet rs1 = p1.executeQuery();
                    while (rs1.next()) {
                        page = new Page(rs1.getInt(1),r.getPage(),r.getSize());
                    }
                    String str = StringUtils.join(r.getParamlist().toArray(), ",");
                    String sql = "  select " + str + " ,Date from WaterPumpInfo_ZA where DeviceID = ? and Date between ? and ? order by Date DESC ";
                    PreparedStatement p = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    p.setString(1, r.getDeviceCode());
                    p.setTimestamp(2, startTime);
                    p.setTimestamp(3, endTime);
                    p.setMaxRows(page.getEndIndex());
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    if (page.getBeginIndex()-1 > 0) {
                        rs.absolute(page.getBeginIndex()-1);//关键代码，直接移动游标为当前页起始记录处
                    }
                    while (rs.next()) {
                        RealtimesRetrunModel rr = new RealtimesRetrunModel();
                        List<RealtimeValueModel> rvlist = new ArrayList<>();
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeValueModel item = new RealtimeValueModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rvlist.add(item);
                        }
                        rr.setDatalist(rvlist);
                        rr.setTime(rs.getString("Date"));
                        rlist.add(rr);
                    }
                    rp.setRlist(rlist);
                    rp.setPage(page);
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rp;
    }
    public static RealtimesPageModel getWaterReport(RealtimeReportModel r) {
        RealtimesPageModel rp = new RealtimesPageModel();
        List<RealtimesRetrunModel> rlist = new ArrayList<>();
        Page page =null;
        switch (r.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql1 = "select COUNT(SIM_ID) from METER_READ_LIST where SIM_ID = ? and CREATE_DATE between ? and ?";
                    PreparedStatement p1 = con.prepareStatement(sql1);
                    p1.setString(1, r.getDeviceCode());
                    java.sql.Timestamp startTime = new java.sql.Timestamp(r.getStartTime().getTime());
                    p1.setTimestamp(2, startTime);
                    java.sql.Timestamp endTime = new java.sql.Timestamp(r.getEndTime().getTime());
                    p1.setTimestamp(3, endTime);
                    ResultSet rs1 = p1.executeQuery();
                    while (rs1.next()) {
                        page = new Page(rs1.getInt(1),r.getPage(),r.getSize());
                    }
                    String str = StringUtils.join(r.getParamlist().toArray(), ",");
                    String sql = "  select " + str + " ,CREATE_DATE from METER_READ_LIST where SIM_ID = ? and CREATE_DATE between ? and ? order by CREATE_DATE DESC ";
                    PreparedStatement p = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    p.setString(1, r.getDeviceCode());
                    p.setTimestamp(2, startTime);
                    p.setTimestamp(3, endTime);
                    p.setMaxRows(page.getEndIndex());
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    if (page.getBeginIndex()-1 > 0) {
                        rs.absolute(page.getBeginIndex()-1);//关键代码，直接移动游标为当前页起始记录处
                    }
                    while (rs.next()) {
                        RealtimesRetrunModel rr = new RealtimesRetrunModel();
                        List<RealtimeValueModel> rvlist = new ArrayList<>();
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeValueModel item = new RealtimeValueModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rvlist.add(item);
                        }
                        rr.setDatalist(rvlist);
                        rr.setTime(rs.getString("CREATE_DATE"));
                        rlist.add(rr);
                    }
                    rp.setRlist(rlist);
                    rp.setPage(page);
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rp;
    }
    public static RealtimesPageModel getFlowmeterReport(RealtimeReportModel r) {
        RealtimesPageModel rp = new RealtimesPageModel();
        List<RealtimesRetrunModel> rlist = new ArrayList<>();
        Page page =null;
        switch (r.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    String sql1 = "select COUNT(fmaddress) from DX_DataFlow where fmaddress = ? and readtime between ? and ?";
                    PreparedStatement p1 = con.prepareStatement(sql1);
                    p1.setString(1, r.getDeviceCode());
                    java.sql.Timestamp startTime = new java.sql.Timestamp(r.getStartTime().getTime());
                    p1.setTimestamp(2, startTime);
                    java.sql.Timestamp endTime = new java.sql.Timestamp(r.getEndTime().getTime());
                    p1.setTimestamp(3, endTime);
                    ResultSet rs1 = p1.executeQuery();
                    while (rs1.next()) {
                        page = new Page(rs1.getInt(1),r.getPage(),r.getSize());
                    }
                    String str = StringUtils.join(r.getParamlist().toArray(), ",");
                    String sql = "  select " + str + " ,readtime from DX_DataFlow where fmaddress = ? and readtime between ? and ? order by readtime DESC ";
                    PreparedStatement p = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    p.setString(1, r.getDeviceCode());
                    p.setTimestamp(2, startTime);
                    p.setTimestamp(3, endTime);
                    p.setMaxRows(page.getEndIndex());
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    if (page.getBeginIndex()-1 > 0) {
                        rs.absolute(page.getBeginIndex()-1);//关键代码，直接移动游标为当前页起始记录处
                    }
                    while (rs.next()) {
                        RealtimesRetrunModel rr = new RealtimesRetrunModel();
                        List<RealtimeValueModel> rvlist = new ArrayList<>();
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeValueModel item = new RealtimeValueModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rvlist.add(item);
                        }
                        rr.setDatalist(rvlist);
                        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = sdf.parse(rs.getString("readtime") + ":00");*/
                        rr.setTime(rs.getString("readtime") + ":00");
                        rlist.add(rr);
                    }
                    rp.setRlist(rlist);
                    rp.setPage(page);
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rp;
    }
    public static List<RealtimesRetrunModel> getWaterpumpPrint(ReportPrintModel r) {
        List<RealtimesRetrunModel> rlist = new ArrayList<>();
        switch (r.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    java.sql.Timestamp startTime = new java.sql.Timestamp(r.getStartTime().getTime());
                    java.sql.Timestamp endTime = new java.sql.Timestamp(r.getEndTime().getTime());
                    List<String> slist = new ArrayList<>();
                    for(ParamViewModel pv : r.getParamlist()){
                        slist.add(pv.getField());
                    }
                    String str = StringUtils.join(slist.toArray(), ",");
                    String sql = "  select " + str + " ,Date from WaterPumpInfo_ZA where DeviceID = ? and Date between ? and ? order by Date DESC ";
                    PreparedStatement p = con.prepareStatement(sql);
                    p.setString(1, r.getDeviceCode());
                    p.setTimestamp(2, startTime);
                    p.setTimestamp(3, endTime);
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        RealtimesRetrunModel rr = new RealtimesRetrunModel();
                        List<RealtimeValueModel> rvlist = new ArrayList<>();
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeValueModel item = new RealtimeValueModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rvlist.add(item);
                        }
                        rr.setDatalist(rvlist);
                        rr.setTime(rs.getString("Date"));
                        rlist.add(rr);
                    }
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rlist;
    }
    public static List<RealtimesRetrunModel> getWaterPrint(ReportPrintModel r) {
        List<RealtimesRetrunModel> rlist = new ArrayList<>();
        switch (r.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    java.sql.Timestamp startTime = new java.sql.Timestamp(r.getStartTime().getTime());
                    java.sql.Timestamp endTime = new java.sql.Timestamp(r.getEndTime().getTime());
                    List<String> slist = new ArrayList<>();
                    for(ParamViewModel pv : r.getParamlist()){
                        slist.add(pv.getField());
                    }
                    String str = StringUtils.join(slist.toArray(), ",");
                    String sql = "  select " + str + " ,CREATE_DATE from METER_READ_LIST where SIM_ID = ? and CREATE_DATE between ? and ? order by CREATE_DATE DESC ";
                    PreparedStatement p = con.prepareStatement(sql);
                    p.setString(1, r.getDeviceCode());
                    p.setTimestamp(2, startTime);
                    p.setTimestamp(3, endTime);
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        RealtimesRetrunModel rr = new RealtimesRetrunModel();
                        List<RealtimeValueModel> rvlist = new ArrayList<>();
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeValueModel item = new RealtimeValueModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rvlist.add(item);
                        }
                        rr.setDatalist(rvlist);
                        rr.setTime(rs.getString("CREATE_DATE"));
                        rlist.add(rr);
                    }
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rlist;
    }
    public static List<RealtimesRetrunModel> getFlowmeterPrint(ReportPrintModel r) {
        List<RealtimesRetrunModel> rlist = new ArrayList<>();
        switch (r.getCompanyCode()) {
            case "657D24644466ADA43DB0729A2CDF4EB4":
                String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
                String user = "sa";
                String password = "ThinkSoft88";
                String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                try {
                    Class.forName(driverClass);
                    Connection con = DriverManager.getConnection(url, user, password);
                    java.sql.Timestamp startTime = new java.sql.Timestamp(r.getStartTime().getTime());
                    java.sql.Timestamp endTime = new java.sql.Timestamp(r.getEndTime().getTime());
                    List<String> slist = new ArrayList<>();
                    for(ParamViewModel pv : r.getParamlist()){
                        slist.add(pv.getField());
                    }
                    String str = StringUtils.join(slist.toArray(), ",");
                    String sql = "  select " + str + " ,readtime from DX_DataFlow where fmaddress = ? and readtime between ? and ? order by readtime DESC ";
                    PreparedStatement p = con.prepareStatement(sql);
                    p.setString(1, r.getDeviceCode());
                    p.setTimestamp(2, startTime);
                    p.setTimestamp(3, endTime);
                    ResultSet rs = p.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    while (rs.next()) {
                        RealtimesRetrunModel rr = new RealtimesRetrunModel();
                        List<RealtimeValueModel> rvlist = new ArrayList<>();
                        for (int j = 0; j < rsmd.getColumnCount() - 1; j++) {
                            RealtimeValueModel item = new RealtimeValueModel();
                            item.setName(rsmd.getColumnName(j + 1));
                            item.setValue(rs.getString(j + 1));
                            rvlist.add(item);
                        }
                        rr.setDatalist(rvlist);
                        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = sdf.parse(rs.getString("readtime") + ":00");
                        String date1 = sdf.format(date);
                        Date date2=sdf.parse(date1);*/
                        rr.setTime(rs.getString("readtime") + ":00");
                        rlist.add(rr);
                    }
                    rs.close();
                    p.close();
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                break;
            case "公司2":
                break;
            default:
                break;
        }
        return rlist;
    }

    public static void main(String[] args) throws Exception{
        // List<RealtimeViewModel> rlist =RealtimeSelect.getWaterpumpRealtimeByCode("18509290670", "657D24644466ADA43DB0729A2CDF4EB4");
        // List<RealtimeViewModel> rlist =RealtimeSelect.getWaterRealtimeByCode("14401782097", "657D24644466ADA43DB0729A2CDF4EB4");
        /*RealtimesViewModel rlist = RealtimeSelect.getFlowmeterRealtimeByCode("1890034", "657D24644466ADA43DB0729A2CDF4EB4");
        for (RealtimeViewModel r : rlist.getRlist()) {
            System.out.println(r);
        }*/
        /*StatisticsViewModel s = new StatisticsViewModel("1890034", "657D24644466ADA43DB0729A2CDF4EB4", 1, "PlusTotalFlux", new Date(2019 - 2 - 5), new Date());
        //StatisticsViewModel s = new StatisticsViewModel("14401782097","657D24644466ADA43DB0729A2CDF4EB4",1,"CURR_WORD",new Date(2018-2-5),new Date());
        //StatisticsReturnModel sr = RealtimeSelect.getWaterParam(s);
        StatisticsReturnModel sr = RealtimeSelect.getFlowmeterParam(s);
        for (StatisticsDataModel s1 : sr.getDatalist()) {
            System.out.println(s1);
        }*/
        /*List<String> list=new ArrayList<String>();
        list.add("first");
        list.add("second");
        list.add("third");

        String s =StringUtils.join(list.toArray(), ",");
        System.out.println(s);*/
        /*List<String> list=new ArrayList<String>();
        list.add("DQSDYL");
        list.add("JSKYL");
        list.add("CSKYL");
        RealtimeReportModel r = new RealtimeReportModel("18509290670", "657D24644466ADA43DB0729A2CDF4EB4", 1, list, new Date(2019 - 2 - 5), new Date(),1,10);
        RealtimesPageModel rp = getWaterpumpReport(r);
        System.out.println(rp);*/


        /*Date d=new Date();

        DateFormat df=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String str=df.format(d);
        System.out.print(str);*/
        /*String s="2012-01-02 03:12:21";
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date du = sp.parse(s);
        java.sql.Timestamp st = new java.sql.Timestamp(du.getTime());
        System.out.println(st);
        Date date = new Date();
        java.sql.Timestamp st1 = new java.sql.Timestamp(date.getTime());
        System.out.println(st1);*/
        List<ParamViewModel> plist = new ArrayList<>();
        ParamViewModel p = new ParamViewModel("压力","Flux");
        plist.add(p);
        ReportPrintModel rp = new ReportPrintModel("1890034", "657D24644466ADA43DB0729A2CDF4EB4",2, plist, new Date(2019 - 2 - 5), new Date());
        //List<RealtimesRetrunModel> rrlist = getWaterpumpPrint(rp);
        //List<RealtimesRetrunModel> rrlist = getWaterPrint(rp);
        List<RealtimesRetrunModel> rrlist = getFlowmeterPrint(rp);
        for (RealtimesRetrunModel rrm :rrlist){
            System.out.println(rrm);
        }


    }
}
