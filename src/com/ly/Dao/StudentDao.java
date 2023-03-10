package com.ly.Dao;

import com.ly.entity.Student;
import com.ly.entity.User;
import com.ly.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

    /**
     * 输入用户id返回对应的学生
     *
     */

    public Student getStudentByUserId(String userId) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from student where uid = ? ";
            pre = con.prepareStatement(sql);
            pre.setString(1, userId);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                Integer uid = resultSet.getInt("uid");
                Integer stuId = resultSet.getInt("stu_id");
                String stuName = resultSet.getString("stu_name");
                Integer stuClass = resultSet.getInt("stu_class");
                String major = resultSet.getString("major");
                Student student = new Student();
                student.setMajor(major);
                student.setUid(uid);
                student.setStuClass(stuClass);
                student.setStuName(stuName);
                student.setStuId(stuId);
                return student;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pre,con);
        }
        return null;
    }

    public void InsertStudent(Student student){
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "insert into student (`uid`,`stu_id`,`stu_name`,`stu_class`,`major`) values (?,?,?,?,?)";
            pre = con.prepareStatement(sql);
            pre.setInt(1, student.getUid());
            pre.setInt(2, student.getStuId());
            pre.setString(3, student.getStuName());
            pre.setInt(4,student.getStuClass());
            pre.setString(5,student.getMajor());
            pre.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pre, con);
        }
    }

    public void UpdateStudent(Student student){
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "update student set stu_id = ?,stu_name = ?, stu_class ?, major = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(1, student.getStuId());
            pre.setString(2, student.getStuName());
            pre.setInt(3,student.getStuClass());
            pre.setString(4,student.getMajor());
            pre.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pre, con);
        }
    }
}
