package com.mt.pojo;

//短信实体类
public class Messages {
    private String type;
    private String phone;
    private String code;

    public Messages() {
    }

    public Messages(String type, String phone, String code) {
        this.type = type;
        this.phone = phone;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                ", code=" + code +
                '}';
    }
}
