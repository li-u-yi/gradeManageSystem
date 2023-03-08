package com.ly.Dao;

import com.ly.entity.Exam;
import com.ly.entity.dto.ScoreDto;
import com.ly.utils.JDBCUtils;
import com.ly.utils.ParamsUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {
    //学生查成绩
    public List<ScoreDto> getExamList(String examNum) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        List<ScoreDto> res = new ArrayList<ScoreDto>();

        try {
            con = JDBCUtils.getConnection();
            String sql = "select * from (exam inner join student inner join course )where exam_num = ? ";
            pre = con.prepareStatement(sql);
            pre.setString(1, examNum);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                ScoreDto scoreDto = new ScoreDto();
                scoreDto.setScore(resultSet.getInt("score"));
                scoreDto.setDate(resultSet.getDate("date"));
                scoreDto.setCourseName(resultSet.getString("course_name"));
                scoreDto.setStuId(resultSet.getInt("stu_id"));
                scoreDto.setStuName(resultSet.getString("stu_name"));
                scoreDto.setTime(resultSet.getTime("time"));
                scoreDto.setStuClass(resultSet.getInt("stu_class"));
                scoreDto.setMajor(resultSet.getString("major"));

                res.add(scoreDto);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pre, con);
        }
        return res;
    }
}
