package com.mt.service;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.Random;

@Service
public class SMSUtil {
    private static final int     APPID          = 1400263577;
    private static final String  APPKEY         = "371b7d77c242220f420400999bb7f1eb";
    private static final Integer TEMPLATE_ID    = 430146;
    private static final String  SMS_SIGN       = "文件存储";
    private static final String  EFFECTIVE_TIME = "5";
    private static final String  NATION_CODE = "86";

    /**
     * 根据用户输入的手机号码发送6位随机数字验证码
     * @param phoneNumbers 用户的手机号码
     * @return 若发送成功则返回验证码，若失败则返回错误信息
     */
    public String sendMessage(String phoneNumbers) {
        String verificationCode = randomCode();
        SmsSingleSenderResult result = null;
        try {
            String[] params = {verificationCode, EFFECTIVE_TIME};
            SmsSingleSender ssender = new SmsSingleSender(APPID, APPKEY);
            result = ssender.sendWithParam(NATION_CODE, phoneNumbers, TEMPLATE_ID, params, SMS_SIGN, "", "");
            if (result.result == 0) { //返回0表示发送成功
                return verificationCode;//发送成功返回验证码
            }
        } catch (HTTPException e) {
            return result.toString();
        } catch (JSONException e) {
            return result.toString();
        } catch (IOException e) {
            return result.toString();
        } catch (com.github.qcloudsms.httpclient.HTTPException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 生成6位随机验证码
     */
    private String randomCode() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        int[] c = new int[6];
        for (int i = 0; i < 6; i++) {
            c[i] = r.nextInt(9) + 1;
            sb.append(c[i]);
        }
        return sb.toString();
    }

}
