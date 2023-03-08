package com.ly.service;

import com.ly.Dao.ExamDao;
import com.ly.entity.dto.ScoreDto;

import java.util.List;

public class ManagerScoreService {
    public List<ScoreDto> getExamList(String manId) {
        ExamDao examDao = new ExamDao();
        return examDao.getExamList("man_id", manId);
    }
}
