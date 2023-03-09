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
    /**
     * 查询成绩
     * @param query
     * @param param
     * @return
     */
    public List<ScoreDto> getExamList(String query,String param) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        List<ScoreDto> res = new ArrayList<ScoreDto>();

        try {
            con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM exam inner join course on exam.course_id = course.course_id inner join student on student.stu_id = exam.stu_id where "+query +" = ? ";
            pre = con.prepareStatement(sql);
            pre.setString(1, param);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                ScoreDto scoreDto = new ScoreDto();
                scoreDto.setScore(resultSet.getInt("score"));
                scoreDto.setExamNum(resultSet.getString("exam_num"));
                scoreDto.setDate(resultSet.getDate("date"));
                scoreDto.setCourseName(resultSet.getString("course_name"));
                scoreDto.setStuId(resultSet.getInt("stu_id"));
                scoreDto.setStuName(resultSet.getString("stu_name"));
                scoreDto.setTime(resultSet.getTime("time"));
                scoreDto.setStuClass(resultSet.getInt("stu_class"));
                scoreDto.setMajor(resultSet.getString("major"));
                scoreDto.setCourseType(resultSet.getString("course_type"));
                if (resultSet.getInt("score") > 60) {
                    scoreDto.setPassOrNot("通过");
                    scoreDto.setColor("success");
                } else {
                    scoreDto.setColor("danger");
                    scoreDto.setPassOrNot("未通过");
                }
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


    /**
     * 更新成绩
     * @param score
     */
    public void updateScore(Exam score){
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtils.getConnection();
            String sql = "update exam set score = ? , man_id = ? where exam_num = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(1, score.getScore());
            pre.setInt(2, score.getManId());
            pre.setString(3, score.getExamNum());
            pre.execute();
            System.out.println(pre);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet,pre,con);
        }
    }

}


