package com.mt.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "mt-server-pay")
public interface PayApi {
    /**
     *
     * @param price
     * @param openId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping(value="/pay/goAlipay/{price}/{openId}/",produces = "text/html; charset=UTF-8")
    String goAlipay(@PathVariable("price")String price,@PathVariable("openId")String openId) throws Exception ;


}
