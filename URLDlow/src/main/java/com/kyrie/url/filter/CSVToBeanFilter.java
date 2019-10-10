package com.kyrie.url.filter;

import com.opencsv.bean.CsvToBeanFilter;

/**
 * @ClassName CSVToBeanFilter
 * @Description    CSV转换实体类过滤器
 * @Author Kyrie
 * @Date 2019/9/30 09:42
 * @Version 1.0
 **/
public class CSVToBeanFilter implements CsvToBeanFilter {
    @Override
    public boolean allowLine(String[] line) {
        if("000000000".equals(line[0]) || "999999999".equals(line[0])){
            return false;
        }
        return true;
    }
}