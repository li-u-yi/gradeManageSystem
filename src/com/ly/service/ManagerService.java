package com.ly.service;

import com.ly.Dao.ExamDao;
import com.ly.Dao.ManagerDao;
import com.ly.entity.Exam;
import com.ly.entity.Manager;
import com.ly.entity.dto.ScoreDto;

import java.util.List;

public class ManagerService {
    /**
     * 获取成绩列表
     * @return
     */
    public List<ScoreDto> getExamList(String manId) {
        ExamDao examDao = new ExamDao();
        return examDao.getExamList("man_id", manId);
    }

    /**
     * 更新成绩
     * @param score
     */
    public void updateScore(Exam score){
        ExamDao examDao = new ExamDao();
        examDao.updateScore(score);

    }

    public boolean isManager(String manId){
        ManagerDao managerDao = new ManagerDao();
        List<Manager> managers = managerDao.getManagerByManID(manId);
        if (managers.isEmpty()){
            return false;

        }else{
            return true;

        }
    }
}
