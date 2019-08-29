package com.example.demo.response;

/**
 * @ClassName UserResponseDTO
 * @Description
 * @Author Kyrie
 * @Date 2019/8/29 14:20
 * @Version 1.0
 **/
public class UserResponseDTO {
    private String restCode;

    private String restDesc;

    private String sysId;

    private String trancId;

    public String getRestCode() {
        return restCode;
    }

    public void setRestCode(String restCode) {
        this.restCode = restCode;
    }

    public String getRestDesc() {
        return restDesc;
    }

    public void setRestDesc(String restDesc) {
        this.restDesc = restDesc;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getTrancId() {
        return trancId;
    }

    public void setTrancId(String trancId) {
        this.trancId = trancId;
    }




}
