package com.kyrie.csv.comm;

/**
 * @ClassName CommEnum
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/10 18:14
 **/
public enum CommEnum {

    FILE_DIR("D:\\csv"),
    FILE_PATH("测试文件"),
    ;
    String descFormat;

    CommEnum(String descFormat) {
        this.descFormat = descFormat;
    }

    public String getDescFormat() {
        return descFormat;
    }

    public void setDescFormat(String descFormat) {
        this.descFormat = descFormat;
    }
}
