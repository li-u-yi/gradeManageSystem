package com.ly.Dao;

import com.ly.entity.Exam;
import com.ly.entity.dto.ScoreDto;
import com.ly.utils.JDBCUtils;
import com.ly.utils.ParamsUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {
    /**
     * 成绩统计栏模糊查询
     * @param query
     * @param role
     * @return
     */
    public List<ScoreDto> getScoreList(String query,Integer role) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        List<ScoreDto> res = new ArrayList<ScoreDto>();

        try {
            con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM exam inner join course on exam.course_id = course.course_id " +
                    "inner join student on student.stu_id = exam.stu_id ";
            if (query != null && !"".equals(query.trim())) {//如果查询条件不空，则加上模糊查询，如果查询条件为空，则直接返回所有值
                query = ParamsUtils.wrapper(query);
                sql += " where stu_name like " + query + " or course_name like " + query + " or major like " + query + " or course_type like " + query +" or stu_class like " + query + " or score like " + query;
            }
            System.out.println(sql);
//        排序    sql += " order by stu_id desc";
            pre = con.prepareStatement(sql);
            resultSet = pre.executeQuery();
            System.out.println(pre);
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
                if(role==2) {
                    if (resultSet.getInt("score") > 0) {
                        scoreDto.setPassOrNot("已录入");
                        scoreDto.setColor("success");
                    } else {
                        scoreDto.setColor("secondary");
                        scoreDto.setPassOrNot("未录入");
                    }
                }else {
                    if (resultSet.getInt("score") > 60) {
                    scoreDto.setPassOrNot("通过");
                    scoreDto.setColor("success");
                    } else {
                        scoreDto.setColor("danger");
                        scoreDto.setPassOrNot("未通过");
                    }

                }
                res.add(scoreDto);
            }

        }catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                JDBCUtils.close(resultSet, pre, con);
            }
            return res;
        }

    /**
     * 查询成绩
     * 精确查询
     * @param query
     * @param param
     * @return
     */
    public List<ScoreDto> getExamList(String query, String param) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        List<ScoreDto> res = new ArrayList<ScoreDto>();

        try {
            con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM exam inner join course on exam.course_id " +
                    "= course.course_id inner join student on student.stu_id = exam.stu_id where " + query + " = ? ";
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
                if (resultSet.getInt("score") >= 60) {
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
     *
     * @param score
     */
    public void updateScore(Exam score) {
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
            JDBCUtils.close(resultSet, pre, con);
        }
    }

    /**
     * 删除成绩
     * @param examNum
     */
    public void deleteScore(String examNum) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;

        try {
            con = JDBCUtils.getConnection();
            String sql = "update exam set score = null , man_id = null where exam_num = ?";
            pre = con.prepareStatement(sql);

            pre.setString(1, examNum);
            pre.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pre, con);
        }
    }

    /**
     * 查询考试编号是否存在
     * @param query
     * @return
     */

    public List<Exam> getAllExamByExamNum(String query) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        List<Exam> res = new ArrayList<Exam>();

        try {
            con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM exam where exam_num = ? ";
            pre = con.prepareStatement(sql);
            pre.setString(1, query);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                Exam exam = new Exam();
                res.add(exam);
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
     * 插入新一行
     * @param exam
     **/
    public void InsertExamNum(Exam exam) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;

        try {
            con = JDBCUtils.getConnection();
            String sql = "insert into exam (`exam_num`,`stu_id`,`date`,`time`,`course_id`) values (?,?,?,?,?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, exam.getExamNum());
            pre.setInt(2, exam.getStuId());
            pre.setDate(3, exam.getDate());
            pre.setTime(4, exam.getTime());
            pre.setInt(5, exam.getCourseId());
            pre.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, pre, con);
        }
    }


}




