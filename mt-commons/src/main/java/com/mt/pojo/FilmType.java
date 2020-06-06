package com.mt.pojo;


public class FilmType {
    private int typeId;
    private String type; //类型

    public FilmType(int typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
