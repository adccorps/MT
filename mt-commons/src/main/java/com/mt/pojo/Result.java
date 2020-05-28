package com.mt.pojo;



import java.util.HashMap;

/**
 * 返回值封装模型类
 * @author yuxue
 * @date 2018-09-07
 */
public class Result extends HashMap<String, Object> {




    public Result(boolean flag) {
      put("flag",flag);
    }




}
