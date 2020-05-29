package com.mt.pojo;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 返回值封装模型类
 * @author yuxue
 * @date 2018-09-07
 */
public class Result extends HashMap<String, Object> {

    private String code;


    public Result(String code ,Object obj) {
        put("code",code);
//       HashMap<String, Object> data = new HashMap<>();
//        data.put("customer",obj);
//        data.put("token", "xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//     数组用
     ArrayList<Object> objects = new ArrayList<>();
        ArrayList<String> type = new ArrayList<>();
        type.add("type1");
        type.add("type2");
        Customer customer = new Customer();
        customer.setCustomerName("123123213213");
        customer.setCustomerId("123123=-==213213");

//      第二种 User+字段  testDemo testDemo = new testDemo(customer, type);
        testDTO testDTO = new testDTO(customer, type);
//        data.put("Dto",testDTO);
//        data.put("type",type);
//        data.put("customer",new Customer());
        objects.add(testDTO);
        BigDecimal i = BigDecimal.valueOf(1111.1111);
//        put("bigDecimal", i);
        put("data",objects);

      //put("customer",customer);
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }


}
