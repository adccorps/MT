package com.mt.pojo;



import com.mt.constants.Code;

import java.math.BigDecimal;
import java.util.*;

/**
 * 返回值封装模型类
 * @author wj
 *   待完成
 */
public class Result extends HashMap<String, Object> {


    private int code;
    private Object data;

    public Result(){};


    public Result(Code code, Object dto) {
        this.code = code.code;
        put("code",code);
        put("data",dto);
    }

    public Result(Code code) {
        this.code = code.code;
        put("code",this.code);
    }

    public Result(int code) {
        this.code = code;
        put("code",code);
    }
    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
