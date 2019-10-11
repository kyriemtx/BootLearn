package com.kyrie.tomysql.entity;

import com.opencsv.bean.CsvBindAndJoinByPosition;
import com.opencsv.bean.CsvBindByPosition;

public class User {

    @CsvBindByPosition(position=0)
    private Integer uid;
    @CsvBindByPosition(position=1)
    private String uname;
    @CsvBindByPosition(position=2)
    private String upassword;
    @CsvBindByPosition(position=3)
    private Integer uage;
    @CsvBindByPosition(position=4)
    private String remark;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uage=" + uage +
                ", remark='" + remark + '\'' +
                '}';
    }
}