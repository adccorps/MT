package com.mt.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class User {
    @ApiModelProperty(name="id",value="xxxx",example="examle1111")
    public String id;
    @ApiModelProperty(name="name",value="xxxx2",example="examle11211")
    public String name;
    @ApiModelProperty(name="password",value="123456",example="123456")
    public String password;
    @ApiModelProperty(name="database",value="xxxx2",example="examle111221")
    public String database;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
