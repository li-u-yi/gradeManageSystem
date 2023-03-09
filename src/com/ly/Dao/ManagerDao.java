package com.ly.Dao;

import com.ly.entity.Manager;
import com.ly.entity.dto.ScoreDto;
import com.ly.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ManagerDao {
    /**
     * 获取所有管理员
     * @param manID
     */
    public List<Manager> getManagerByManID(String manID){
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        List<Manager> res = new ArrayList<Manager>();
        try {
            con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM manager where man_id = ? ";
            pre = con.prepareStatement(sql);
            pre.setString(1, manID);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                Manager manager = new Manager();
                manager.setManId(resultSet.getInt("man_id"));
                res.add(manager);
            }
    }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet,pre,con);
        }
        System.out.println(res);
        return res;
    }

}
