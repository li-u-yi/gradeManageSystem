package com.ly.service;

import com.ly.Dao.CourseDao;
import com.ly.entity.Course;

import java.util.List;

public class CourseService {
    //获取课程列表 还没实现

    public List<Course> getCourseList(String query){
        CourseDao courseDao = new CourseDao();
        List<Course> courses = courseDao.getCouseList();
        return courses;
    }
}
