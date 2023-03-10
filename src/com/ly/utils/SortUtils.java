package com.ly.utils;

import com.ly.entity.dto.ScoreDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortUtils {
    //成绩排序工具
    //顺序
    public static List<ScoreDto> SortScore(List<ScoreDto> list,String sortKey){
        List<ScoreDto> scores = null;
        switch (sortKey) {
                case "score":
                    scores = list.stream()
                            .sorted(Comparator.comparing(ScoreDto::getScore))
                            .collect(Collectors.toList());
                    break;
                case "stuClass":
                    scores = list.stream()
                            .sorted(Comparator.comparing(ScoreDto::getStuClass))
                            .collect(Collectors.toList());
                    break;
                case "stuName":
                    scores = list.stream()
                            .sorted(Comparator.comparing(ScoreDto::getStuName))
                            .collect(Collectors.toList());
                    break;
                case "major":
                    scores = list.stream()
                            .sorted(Comparator.comparing(ScoreDto::getMajor))
                            .collect(Collectors.toList());
                    break;
                case "courseName":
                    scores = list.stream()
                            .sorted(Comparator.comparing(ScoreDto::getCourseName))
                            .collect(Collectors.toList());
                    break;
                case "courseType":
                    scores = list.stream()
                            .sorted(Comparator.comparing(ScoreDto::getCourseType))
                            .collect(Collectors.toList());
                    break;
                case "date":
                    scores = list.stream()
                            .sorted(Comparator.comparing(ScoreDto::getDate))
                            .collect(Collectors.toList());
                    break;
                case "tiem":
                    scores = list.stream()
                            .sorted(Comparator.comparing(ScoreDto::getTime))
                            .collect(Collectors.toList());
                    break;
                }
            return scores;
    }


    //降序 静态方法通过类名直接调用
    public static List<ScoreDto> SortScoreReverse(List<ScoreDto> list,String sortKey){
        List<ScoreDto> scores = null;
        switch (sortKey) {
            case "score":
                scores = list.stream()
                        .sorted(Comparator.comparing(ScoreDto::getScore).reversed())
                        .collect(Collectors.toList());
                break;
            case "stuClass":
                scores = list.stream()
                        .sorted(Comparator.comparing(ScoreDto::getStuClass).reversed())
                        .collect(Collectors.toList());
                break;
            case "stuName":
                scores = list.stream()
                        .sorted(Comparator.comparing(ScoreDto::getStuName).reversed())
                        .collect(Collectors.toList());
                break;
            case "major":
                scores = list.stream()
                        .sorted(Comparator.comparing(ScoreDto::getMajor).reversed())
                        .collect(Collectors.toList());
                break;
            case "courseMame":
                scores = list.stream()
                        .sorted(Comparator.comparing(ScoreDto::getCourseName).reversed())
                        .collect(Collectors.toList());
                break;
            case "courseType":
                scores = list.stream()
                        .sorted(Comparator.comparing(ScoreDto::getCourseType).reversed())
                        .collect(Collectors.toList());
                break;
            case "date":
                scores = list.stream()
                        .sorted(Comparator.comparing(ScoreDto::getDate).reversed())
                        .collect(Collectors.toList());
                break;
            case "time":
                scores = list.stream()
                        .sorted(Comparator.comparing(ScoreDto::getTime).reversed())
                        .collect(Collectors.toList());
                break;
        }
        return scores;
    }
}
