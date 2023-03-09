package com.ly.service;

import com.ly.Dao.ExamDao;
import com.ly.entity.Exam;
import com.ly.entity.dto.ScoreDto;

import java.util.List;

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
}
