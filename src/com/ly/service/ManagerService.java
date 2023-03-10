package com.ly.service;

import com.ly.Dao.ExamDao;
import com.ly.Dao.ManagerDao;
import com.ly.entity.Exam;
import com.ly.entity.Manager;
import com.ly.entity.dto.ScoreDto;
import com.ly.utils.SortUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerService {
    /**
     * 查询成绩
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

    /**
     * 判断是否是管理员
     * @param manId
     * @return
     */
    public boolean isManager(String manId){
        ManagerDao managerDao = new ManagerDao();
        List<Manager> managers = managerDao.getManagerByManID(manId);
        if (managers.isEmpty()){
            return false;

        }else{
            return true;

        }
    }

    /**
     * 删除成绩
     * @param examNum
     */
    public void deleteScore(String examNum){
        ExamDao examDao = new ExamDao();
        examDao.deleteScore(examNum);
    }


    /**
     * 判断考试编号是否存在
     * @param examNum
     * @return
     */
    public boolean isExam(String examNum){
        ExamDao examDao = new ExamDao();
        List<Exam> exams= examDao.getAllExamByExamNum(examNum);
        if (exams.isEmpty()){
            return false;

        }else{
            return true;

        }
    }

    /**
     * 返回管理员查询的所有成绩
     * 模糊查询
     * @param query
     * @return
     */
    public List<ScoreDto> managerGetStudentAllScoreList(String query){
        List<ScoreDto> list;
        ExamDao examDao = new ExamDao();
        return examDao.getScoreList(query,2);
    }

    /**
     * 管理员统计，实现排序
     * @param query
     * @param sortKey
     * @param sortMethod
     * @return
     */
    public List<ScoreDto> getAllScoreList(String query,String sortKey,String sortMethod){
        ExamDao examDao = new ExamDao();
        List<ScoreDto> scores = null;
        ScoreDto scoreDto = new ScoreDto();
        scores = examDao.getScoreList(query,2);
        if(!sortKey.equals("--")||sortMethod.equals("--")) {
            List<ScoreDto> list = examDao.getScoreList(query,2);
            if(sortMethod.equals("1"))
                scores=SortUtils.SortScore(list,sortKey);
            else if (sortMethod.equals("2"))
                scores=SortUtils.SortScoreReverse(list,sortKey);
        }
        return scores;
    }

}
