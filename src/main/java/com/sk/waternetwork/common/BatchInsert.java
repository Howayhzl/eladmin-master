package com.sk.waternetwork.common;

import com.microsoft.sqlserver.jdbc.SQLServerBulkCopy;
import com.microsoft.sqlserver.jdbc.SQLServerBulkCopyOptions;
import com.sk.waternetwork.model.AreasSiteRelationship;
import com.sk.waternetwork.model.RandomGUID;
import com.sun.rowset.CachedRowSetImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/2/15.
 */
public class BatchInsert<T> {
    /*
    获取空的CachedRowSet对象
    其中BaseDao为最常见的JDBC操作, 这里就不贴出, 相信大家看的懂
    @throws SQLException
    */
    public CachedRowSetImpl getCachedRowSet(String tableName) throws SQLException {
        String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=waternetDB";
        String user = "sa";
        String password = "ThinkSoft88";
        String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driverClass);
            Connection a = DriverManager.getConnection(url, user, password);
            //查询出空值用于构建CachedRowSetImpl对象以省去列映射的步骤
            ResultSet rs = a.createStatement().executeQuery("select * from " + tableName + " where 1=0");
            CachedRowSetImpl crs = new CachedRowSetImpl();
            crs.populate(rs);
            //获取crs以后关闭数据库连接
            a.close();
            return crs;
        } catch (Exception e) {
            return null;
        }
    }

    /* 向CachedRowSet对象插入一条数据
       循环调用这一个方法，将想插入数据库的数据先插入到CachedRowSet对象里
       @param crs
       @param fmt
       @return
       @throws SQLException
    */
    public CachedRowSetImpl insertIntoCachedRowSet(CachedRowSetImpl crs,T t) throws SQLException {
        //移动指针到“插入行”，插入行是一个虚拟行
        crs.moveToInsertRow();

        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            crs.updateObject(field.getName().toString(), getFieldValueByName(field.toString(),t.getClass()));
        }

//        //移动指针到“插入行”，插入行是一个虚拟行
//        crs.moveToInsertRow();
//        //更新虚拟行的数据
//        crs.updateString("Code", a.getCode());
//        crs.updateString("AreaCode", a.getAreacode());
//        crs.updateString("SiteCode", a.getSitecode());
//        crs.updateString("Creator", a.getCreator());
//        java.sql.Date createTime = new java.sql.Date(a.getCreatetime().getTime());
//        crs.updateDate("CreateTime", createTime);
//        crs.updateString("Modifier", a.getModifier());
//        crs.updateInt("ValidStatus", a.getValidstatus());
        //插入虚拟行
        crs.insertRow();
        //移动指针到当前行
        crs.moveToCurrentRow();
        return crs;
    }

    /*根据属性名获取属性值*/
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(fieldName.lastIndexOf(".") + 1);
            firstLetter = upperCase(firstLetter);
            String getter = "get" + firstLetter;
            Method  method = o.getClass().getMethod("getSitecode", new Class[] {});
            Object value = method.invoke(o, null);
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    public String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /*
    使用BulkCopy和RowSet进行批量插入
     @param crs
     @param batchSize
     */
    public void insertBatch(CachedRowSetImpl crs) throws SQLException {
        //数据库连接字符串
        String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=waternetDB"
                + ";user=sa;password=ThinkSoft88";
        SQLServerBulkCopyOptions copyOptions = new SQLServerBulkCopyOptions();
        copyOptions.setKeepIdentity(true);
        //copyOptions.setBatchSize(8000);
        copyOptions.setUseInternalTransaction(true);
        SQLServerBulkCopy bulkCopy = new SQLServerBulkCopy(url);
        bulkCopy.setBulkCopyOptions(copyOptions);
        bulkCopy.setDestinationTableName("AreasSiteRelationship");
        bulkCopy.writeToServer(crs);
        crs.close();
        bulkCopy.close();
    }

    public int insertBatchAreasSiteRelationship(List<AreasSiteRelationship> list) {

        return 0;
    }

    public static void main(String[] args) throws SQLException {
        List<AreasSiteRelationship> areasSiteRelationshipList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AreasSiteRelationship a = new AreasSiteRelationship();
            a.setCode(RandomGUID.createCode());
            a.setAreacode("266864C83893A30C87670A97D7D1A93D");
            a.setSitecode(RandomGUID.createCode());
            a.setCreator("42FADDEFBEBCFBBEAAF2034873DDF70B");
            a.setCreatetime(new Date());
            a.setValidstatus(1);
            areasSiteRelationshipList.add(a);
        }
        BatchInsert<AreasSiteRelationship> batchInsert = new BatchInsert<AreasSiteRelationship>();
        CachedRowSetImpl c = batchInsert.getCachedRowSet("[AreasSiteRelationship]");
        for (AreasSiteRelationship as : areasSiteRelationshipList) {
            c = batchInsert.insertIntoCachedRowSet(c, as);
        }
        batchInsert.insertBatch(c);
        // batchInsert.insertBatch(batchInsert.insertIntoCachedRowSet(batchInsert.getCachedRowSet(),a),1);
    }
}
