package com.sk.waternetwork.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/8.
 */
public class TestModel {
    public static JSONObject query(JSONObject object, int pageIndex, int pageSize) {
        JSONObject result = new JSONObject();
        if(object == null || object.getBoolean("success") == false) {
            result.put("success", false);
            if(object == null) {
                result.put("msg", "没有成功获取到基本对象");
            } else if(object.getString("msg") != null) {
                result.put("msg", object.getString("msg"));
            }
        } else {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            //Statement statement = null;
            ResultSet rs = null;

            String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=ZAElecWaterIC";
            String user = "sa";
            String password = "ThinkSoft88";
            String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            try {
                Class.forName(driverClass);
                connection = DriverManager.getConnection(url, user, password);
                String sql = object.getString("sql");
                System.out.println(sql);
                preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                if(pageIndex == 1 && pageSize == 1) {
                    rs = preparedStatement.executeQuery();
                } else {
                    preparedStatement.setMaxRows(((pageIndex - 1) * pageSize) + pageSize);//查询的最大行数
                    //preparedStatement.setMaxRows(pageSize);
                    rs = preparedStatement.executeQuery();
                    //rs.first();
                    rs.absolute((pageIndex - 1) * pageSize + 1);//利用绝对定位定位到结果集的每页第二条数据
                    rs.relative(-1);//利用结果集的相对定位定位到每页的第一条数据
                }
                JSONArray datas = new JSONArray();
                JSONArray data = null;
                ResultSetMetaData metaData = null;
                int colnumCount = 0;
                String colnumName = null;
                Object tmp = null;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Reader reader = null;
                BufferedReader bufferedReader = null;
                char[] chbTmp = null;
                StringBuffer sb = new StringBuffer();
                while(rs.next()) {
                    //获取数据
                    data = new JSONArray();
                    metaData = rs.getMetaData();
                    colnumCount = metaData.getColumnCount() + 1;
                    for (int i = 1; i < colnumCount; i++) {
                        colnumName = metaData.getColumnName(i);
                        tmp = rs.getObject(colnumName);
                        if(tmp == null) {
                            data.add("");
                        } else {
                            if(tmp.getClass() == Timestamp.class) {
                                data.add(dateFormat.format(tmp));
                            } else if(tmp.getClass() == Clob.class) {
                                chbTmp = new char[20];
                                reader = rs.getClob(colnumName).getCharacterStream();
                                bufferedReader = new BufferedReader(reader);
                                bufferedReader.read(chbTmp);
                                sb.delete(0, chbTmp.length);
                                sb.append(chbTmp);
                                data.add(sb.toString() + "...");
                            } else {
                                data.add(tmp);
                            }
                        }
                    }
                    datas.add(data);;
                }
                JSONArray colnums = new JSONArray();
                if(datas.size() > 0) {
                    //获取列名
                    metaData = rs.getMetaData();
                    colnumCount = metaData.getColumnCount() + 1;
                    for (int i = 1; i < colnumCount; i++) {
                        colnumName = metaData.getColumnName(i);
                        colnums.add(colnumName);
                    }
                } else {
                    colnums.add("没有成功获取列的信息");
                }
                result.put("colnum", colnums);
                result.put("datas", datas);
                result.put("success", true);
                rs.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success", false);
                result.put("msg", e.getMessage());
            }
        }
        return result;
    }
    public static void main(String[] args) {
        /*JSONObject json = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("DQSDYL");
        list.add("JSKYL");
        list.add("CSKYL");
        String str = StringUtils.join(list.toArray(), ",");
        String sql = "select "+str+",Date from WaterPumpInfo_ZA where DeviceID = 18509290670 order by Date desc";
        json.put("sql",sql);
        json.put("success",true);
        JSONObject j1 = query(json,1,10);
        System.out.println(j1);*/
        Page page = new Page(88, 1);
        System.out.println(page);
    }
}
