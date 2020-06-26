package com.mt.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * @date 2019-3-17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "announce")
public class Announce extends BaseModel implements Serializable {

    @Excel(name = "序号", orderNum = "0")
    @Column(name = "id",type = MySqlTypeConstant.INT, length = 10,isKey = true,isAutoIncrement = true)
    private int id;

    @Excel(name = "内容", orderNum = "1")
    @Column(name = "content",type = MySqlTypeConstant.VARCHAR,length = 400)
    private String content;

    @Column(name = "picture",type = MySqlTypeConstant.VARCHAR,length = 30)
    private String picture;

    @Excel(name = "时间", exportFormat = "yyyy-MM-dd hh:mm" ,orderNum = "2")
    @Column(name = "date",type = MySqlTypeConstant.DATETIME)
    private Timestamp date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
