package com.kyrie.tomysql.service;
import	java.util.Map;
import java.io.*;

import com.kyrie.tomysql.dao.UserMapper;
import com.kyrie.tomysql.entity.User;
import com.kyrie.tomysql.filter.CsvBeanFilter;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName CSVService
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/11 9:44
 **/
@Service
@Slf4j
public class CSVService {

   @Autowired
   private UserMapper userMapper;
    /**
     * 指定文件读入mysql数据库中
     * @param filePath
     * @return
     * @throws IOException
     */
    public int writeToMysql(String filePath) throws IOException {
        int size = 0;
        FileInputStream inputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
        if(StringUtils.isNotBlank(filePath)){
            int result = userMapper.deleteAllUser();
            log.info("------------清空数据库结束---------------------");
            log.info("解析文件开始,文件全路径：",filePath);
            CSVReaderBuilder readerBuilder = new CSVReaderBuilder(inputStreamReader);
            CSVParserBuilder parserBuilder = new CSVParserBuilder();
            parserBuilder.withSeparator('|');
            readerBuilder.withCSVParser(parserBuilder.build());
            CSVReader reader = readerBuilder.build();
            ColumnPositionMappingStrategy<User> mapping = new ColumnPositionMappingStrategy<>();
            mapping.setType(User.class);
            CsvBeanFilter csvBeanFilter = new CsvBeanFilter();
            CsvToBean<User> csvToBean = new CsvToBean<>();
            csvToBean.setCsvReader(reader);
            csvToBean.setMappingStrategy(mapping);
            csvToBean.setFilter(csvBeanFilter);
            Iterator<User> cit = csvToBean.iterator();
            while (cit.hasNext()){
                User user = cit.next();
                log.info("写入数据："+ user.toString());
                userMapper.insert(user);
               size ++;
            }
        }
        return  size;
    }

    public void readFromMysql(int age) throws IOException{
        //创建保存数据的文件
        File file = new File("D:\\zazq");
        if(!file.exists()){
            file.mkdirs();
        }
        File filePath = new File(file,"从数据库读取文件.txt");
        List<User> users = userMapper.selectByAge(age);
        try (FileOutputStream fos = new FileOutputStream(filePath);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos)){
            ColumnPositionMappingStrategy<User> mapping = new ColumnPositionMappingStrategy<> ();
            mapping.setType(User.class);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(outputStreamWriter)
                    .withSeparator('|')
                    .withEscapechar('\\')
                    .withMappingStrategy(mapping)
                    .withApplyQuotesToAll(false)
                    .build();
            beanToCsv.write(users);
        }catch (Exception e){
            log.info("从数据库写入文件失败",e.getMessage());
        }
    }

}
