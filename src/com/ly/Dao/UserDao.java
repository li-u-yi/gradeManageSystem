package com.ly.Dao;

import com.ly.entity.User;
import com.ly.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDao {

    public User getUserByUserIdAndPasswordAndRole(String  userid, String password, String role) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from user where uid = ? and psw = ? and role = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, userid);
            pre.setString(2, password);
            pre.setString(3,role);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                Integer uid = resultSet.getInt("uid");
                String psw = resultSet.getString("psw");
                Integer role1 = resultSet.getInt("role");
                User user = new User();

                user.setUid(uid);
                user.setPsw(psw);
                user.setRole(role1);
                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pre,con);
        }
        return null;
    }
}
