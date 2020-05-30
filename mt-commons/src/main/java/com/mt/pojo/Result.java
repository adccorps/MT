package com.mt.pojo;



import java.math.BigDecimal;
import java.util.*;

/**
 * 返回值封装模型类
 * @author wj
 *   待完成
 */
public class Result extends HashMap<String, Object> {


    private String code;

    public Result(){};
//数组需要使用arrayList
    public Result(String code,Object dto) {
        this.code = code;
        put("code",code);
     //   data.put("data",dto);
        put("data",dto);
    }



    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
