package com.kyrie.url.util;

/**
 * @ClassName ContantsEnum
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/10 17:43
 **/

public enum  ContantsEnum {

    PAY_FILE_NAME("消费对账账单"),
    TRANS_FILE_NAME("代付对账账单"),
    ;

    String descFormat;

    ContantsEnum(String descFormat) {
        this.descFormat = descFormat;
    }

    public String getDescFormat() {
        return descFormat;
    }

    public void setDescFormat(String descFormat) {
        this.descFormat = descFormat;
    }
}
