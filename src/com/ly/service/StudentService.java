package com.ly.service;

import com.ly.Dao.ExamDao;
import com.ly.Dao.StudentDao;
import com.ly.entity.Exam;
import com.ly.entity.Student;
import com.ly.entity.dto.ScoreDto;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    /**
     * 查询考试成绩
     * @param examNum
     * @return
     */
    public List<ScoreDto> getExamList(String examNum){
        ExamDao examDao = new ExamDao();
        return examDao.getExamList("exam_num",examNum);
    }

    /**
     * 插入考试信息
     * @param exam
     */
    public void insertExam(Exam exam){
        ExamDao examDao = new ExamDao();
        examDao.InsertExamNum(exam);

    }

    /**
     * 学生查询自己的所有考试成绩,用过滤器过滤不是登陆学生的成绩
     * 模糊查询
     * @param stuId
     * @param query
     * @return
     */

    public List<ScoreDto> getStudentAllScoreList(String stuId,String query){
        List<ScoreDto> list;
        ExamDao examDao = new ExamDao();
        list = examDao.getScoreList(query,1);
        //过滤器，留下本学生用户以及大于0的成绩
        return list.stream().filter(exam -> exam.getStuId()==Integer.valueOf(stuId)).filter(exam->exam.getScore()>0).collect(Collectors.toList());
    }

    /**
     * 根据用户id（在cookie里） 返回学生id（用于查询成绩表）
     * @param uid
     * @return
     */

    public String getStudentIdByUid(String uid){
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.getStudentByUserId(uid);
        return String.valueOf(student.getStuId());
    }
}
