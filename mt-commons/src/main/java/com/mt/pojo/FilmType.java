package com.mt.pojo;


public class FilmType {
    private int typeId;
    private String type; //类型

    public FilmType(int typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public int getType_id() {
        return typeId;
    }

    public void setType_id(int type_id) {
        this.typeId = type_id;
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
