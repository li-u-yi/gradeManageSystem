package com.ly.utils;

public class ParamsUtils {
    //模糊查询工具
    public static String wrapper(String name) {
        if(name == null) {
            return null;
        }
        name = "'%" + name + "%'";
        return name;
    }
}
