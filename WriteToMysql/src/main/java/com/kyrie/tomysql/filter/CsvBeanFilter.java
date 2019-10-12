package com.kyrie.tomysql.filter;

import com.opencsv.bean.CsvToBeanFilter;
import org.springframework.stereotype.Component;

/**
 * @ClassName CSVBeanFilter
 * @Description 按要求过滤文件中的数据(不想入库的列)
 * @Author tengxiao.ma
 * @Date 2019/10/11 10:27
 **/
@Component
public class CsvBeanFilter implements CsvToBeanFilter {

    private static final String start = "000";
    private static final String end = "999";
    @Override
    public boolean allowLine(String[] line) {
        //过滤第一列为000或者999的行

        if (start.equals(line[0]) || end.equals(line[0])) {
            return false;
        }
        return true;
    }
}
