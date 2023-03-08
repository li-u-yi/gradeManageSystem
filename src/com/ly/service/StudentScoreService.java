package com.ly.service;

import com.ly.Dao.ExamDao;
import com.ly.entity.dto.ScoreDto;

import java.util.List;

public class StudentScoreService {
    public List<ScoreDto> getExamList(String examNum){
        ExamDao examDao = new ExamDao();
        return examDao.getExamList("exam_num",examNum);
    }
}
