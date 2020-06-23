package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102400749764";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCYioIKlVI6MmbQmsVdVn1aL25JCdfeiGMf78gXCXqsC4LscYsnBRSmx2BInSButDsznRBR0t0O4AxFzW2RAL8fL7Tr1nNyberCcD2TNQYI3OlUezlNcZbhRgrrSfLsG0476MkfSqBPCY3f/NFEQrf1zJQt79N7x82fhYekAnij7v7DttT0GP26Jun2vieK6ZD/YetInYjKXpGyZUychub4gVPqJ8ZkYN77ByRItU/1TDwWYPKE3iUXjJ3143cdZ40eowej2pKnmBExAs+EcKjiolkzhjnkxIoW2wZPSUaAUMaViHEyavPAUonPaD6AvN5Hjuk4GvwJyU0tDqdHGzBjAgMBAAECggEAKLC546zVVGThfD/s6esKYSZJ2v3fMaNcHcbOryZ+LKqdcAkRv4Thb2O70WLopd8585iwI8OF6FPnsi8MTSPP17fYIRkBjsK3XsqmAkCgrXiQXVLJhFkKkGkovH7raAQYqG5+R/SWMr8vs1IzWGwbuluqI17YISq5NRZfimaGW+QWbwwTRkkS9f+hYPtduKoehfeBlKTRPWCVsZt2HOk00WjNsq7Won3WmZZ+qTDWvOhwvGl71F8d5aNpJVycVsHEMZO8EpZbMNnznoMv2DtfL7csFirBe1hEBdJXTRLCpqZiSdH5KXU2o0uZ+XFGZEmavJcihaK0d99PsJGX7usR4QKBgQD6wEQHhuFkqLGDlHzZOPjegdAFr9GuX/mdTfghBw5UbVeGCRFo3JuzffztYxv3mdinlac3XbMNn3li8jBQur/9x+7+0H5eVYCjsb27cAP91dJsccO5BK9hV0SIHrHKkIH5qxFRbkxgXLuGhKPKaQE7AEwjU1Qkn23xwKuoWOdgOwKBgQCbu/Nl646uFKvpo+9/DbuGAHvKpn81yf2VjqvKX70jTTJtgJt06VG0F7geW9bKdtFc9jGKr0gchlGhVTW3itXKZDSrVgEfzUlMC1bKwMMh+D9OpQRCK3jGQQhB7NlxbmbJofm7HTSvrE6CHrN4JAieeO8VQDkPbvzLgexgAqFV+QKBgFqvqmrmdyHGeNzTmQuetTMT074axkTAZTBlAHZBbQdPvDW3ldpM3urdh9n63CSCOX7yetVlR9qHcIk+egbYY5NO+bqigPFxDuMk5y+g5XCqIj4iLtz9OsiDnT91imtuM/Ot0MeYknrPTurpkaskqtNB2kd0XZwZJNQoEG0EKjn9AoGAF7EGHDEzqYP3izmnS5rZNk+IhZHCtHogG8pyk/zwlxg9Xa889xIvncgl+GhcSry8qPnDG6gCvmQosvR1kZCLaZjI8m/JB/+A8RKgh4O/q8FKUDqGZVKbsv1dtjnD8p+q/22mwjJ1O2xpHR5yiwpgTUt0g7UbeR+XUZZYUVrVFHECgYBTYmM9dvsi5W5sjGORtuz3b8Qwvm/cA48hil1+p/3VbhMU9a0sec8UWcHxUbneUy1FVPUdMNGv9hZpiv3loV8JwQ2OBz1UIL6aKYJz6g3NG+2eusyfGONRsvCHazEd115FIL7nxelEBTD3+iN8CqERiyOEKzFTFstbiB7Fk8VWRw==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmH9jUKEblj6M6FQMA2jap5Ss1CwIne9u+iBW4EWnUQNfXX1RuGIt/+0Vu6vvoXsyhewS9BLVWiFiD405Iegy9T+BWaq1+SKRsn2p1DNeDjBEa/xMSo8VWNVbvh48cLrfReeMXYjdZpidGcB3pjJpwEf+zkT2/ep+1NI1iy96I1oCys970Hcpu4SPWlnDeia0PyMuEQ/k6Ui4Llxhis/Zutc26ehSeGwYMqwmYNhmKBAzzRVLTHleg6kjSrJCEFSXNg6bvIxJiox7M4XYNtln+Nq0bvtR3eIAgIOmWfvmtkcLwgkto1eQ+I/KBKqpcsiML7L2dib8u58xF2fHRtaXMwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://134.175.245.249:8080/yibu";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://134.175.245.249:8080/tongbu";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    //日志地址
    public static String log_path = "D:\\AliPay";



    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}