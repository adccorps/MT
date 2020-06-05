package com.mt.pojo;


public class FilmType {
    private int type_id;
    private String type; //类型

    public FilmType(int type_id, String type) {
        this.type_id = type_id;
        this.type = type;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FilmType() {
        super();
    }
}
