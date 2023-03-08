package com.ly.entity.dto;

import java.sql.Date;
import java.sql.Time;

public class ScoreDto {
    private String examNum;
    private int courseId;
    private int manId;
    private int stuId;
    private Date date;
    private Time time;
    private int score;
    private int stuClass;
    private String major;

    public int getStuClass() {
        return stuClass;
    }

    public void setStuClass(int stuClass) {
        this.stuClass = stuClass;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    private String courseName;
    private String stuName;

    public String getExamNum() {
        return examNum;
    }

    public void setExamNum(String examNum) {
        this.examNum = examNum;
    }


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
