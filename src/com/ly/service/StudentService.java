package com.ly.service;

import com.ly.Dao.ExamDao;
import com.ly.Dao.StudentDao;
import com.ly.entity.Exam;
import com.ly.entity.Student;
import com.ly.entity.dto.ScoreDto;
import com.ly.utils.SortUtils;

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
     * @param sortKey
     * @param sortMethod
     * @return
     */

    public List<ScoreDto> getStudentAllScoreList(String stuId,String query,String sortKey,String sortMethod){
        List<ScoreDto> list;
        ExamDao examDao = new ExamDao();
        list = examDao.getScoreList(query,1);
        //过滤器，留下本学生用户以及大于0的成绩
        list = list.stream().filter(exam -> exam.getStuId()==Integer.valueOf(stuId))
                .filter(exam->exam.getScore()>0).collect(Collectors.toList());
        if(!sortKey.equals("--")||sortMethod.equals("--")) {
            if(sortMethod.equals("1"))
                list = SortUtils.SortScore(list,sortKey);
            else if (sortMethod.equals("2"))
                list = SortUtils.SortScoreReverse(list,sortKey);
        }
        return list;
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

    /**
     * 根据用户id返回学生对象
     * @param uid
     * @return
     */

    public Student getStudentByUid(String uid){
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.getStudentByUserId(uid);
        return student;
    }

    /**
     * 判断两个学生对象是否相等
     * @param obj
     * @param student
     * @return
     */

    public boolean checkStudent(Student obj,Student student){
        if(obj.getStuId()==student.getStuId()&&obj.getStuName()==student.getStuName()&&obj.getMajor()==student.getMajor()&&obj.getStuClass()== student.getStuClass())
            return true;
        else
            return false;

    }

    public void insertStu(Student student){
        StudentDao studentDao = new StudentDao();
        studentDao.InsertStudent(student);
    }

    public void updateStu(Student student){
        StudentDao studentDao = new StudentDao();
        studentDao.UpdateStudent(student);
    }
}
