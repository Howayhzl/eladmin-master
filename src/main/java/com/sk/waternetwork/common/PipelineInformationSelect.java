package com.sk.waternetwork.common;

import com.sk.waternetwork.model.PipelineInformation;
import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/14.
 */
public class PipelineInformationSelect {
    public static List<PipelineInformation> getPipelineByCompanyCode(String code) {
        String url = "jdbc:sqlserver://114.116.99.96;DatabaseName=waternetDB";
        String user = "sa";
        String password = "ThinkSoft88";
        String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        List<PipelineInformation> plist = new ArrayList<>();
        try {
            Class.forName(driverClass);
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "select Code, Name, CompanyCode, Diameter, Material, Length, Gis from PipelineInformation where CompanyCode = ?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, code);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                PipelineInformation pp = new PipelineInformation();
                pp.setCode(rs.getString(1));
                pp.setName(rs.getString(2));
                pp.setCompanycode(rs.getString(3));
                pp.setDiameter(rs.getString(4));
                pp.setMaterial(rs.getString(5));
                pp.setLength(rs.getString(6));
                pp.setGis(rs.getString(7));
                plist.add(pp);
            }
            rs.close();
            p.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return plist;
    }
}
