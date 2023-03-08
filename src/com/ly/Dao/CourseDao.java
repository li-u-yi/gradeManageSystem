package com.ly.Dao;

import com.ly.entity.Course;
import com.ly.utils.JDBCUtils;
import com.ly.utils.ParamsUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseDao {
    //获取所有课程
    public List<Course> getCouseList(){
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        List<Course>res = new ArrayList<Course>();
        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from course ";
            pre = con.prepareStatement(sql);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                Integer courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                String courseType = resultSet.getString("course_type");
                Course course = new Course();
                course.setCourseId(courseId);
                course.setCourseName(courseName);
                course.setCourseType(courseType);
                res.add(course);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pre,con );
        }
        return res;
    }
}

