package com.mt.pojo;

import io.swagger.annotations.ApiModel;

@ApiModel
public class FilmType {
    private int typeId;
    private String type; //类型

    public FilmType() {
        super();
    }

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
}
