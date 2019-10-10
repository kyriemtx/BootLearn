package com.kyrie.url.service;

import com.kyrie.url.entity.PayFileInfo;
import com.kyrie.url.filter.CSVToBeanFilter;
import com.kyrie.url.util.ContantsEnum;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName IoService
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/9/30 9:56
 * @Version 1.0
 **/
@Service
@Slf4j
public class IoService {

    /**
     * 下文文件到指定目录
     * @param date
     * @param fileUrl
     * @return
     * @throws Exception
     */
    public String fileDown(String date,String fileUrl) throws Exception{
        log.info("下载远程文件开始,地址：",fileUrl);
        URL url = new URL(fileUrl);
        File file = this.createFile(date);
        String filePath = file.getAbsolutePath();
        byte [] bytes = new byte[1024*4];
        //把下载的文件写入上面创建的文件中
        InputStream inputStream = url.openStream(); FileOutputStream outputStream = new FileOutputStream(file);
           int len = 0;
           while ((len = inputStream.read(bytes)) > 0){
               outputStream.write(bytes,0,len);
           }
        return filePath;
    }

    public List<PayFileInfo> parseFile(String filePath) throws Exception{
        FileInputStream inputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
        List<PayFileInfo> list = new ArrayList<>();
        if(StringUtils.isNotBlank(filePath)){
           log.info("解析文件开始，文件名：",filePath);
            CSVReaderBuilder csvReaderBuilder = new CSVReaderBuilder(inputStreamReader);
            CSVParserBuilder csvParserBuilder = new CSVParserBuilder();
            csvParserBuilder.withSeparator('|');
            csvReaderBuilder.withCSVParser(csvParserBuilder.build());
            CSVReader reader = csvReaderBuilder.build();
            ColumnPositionMappingStrategy<PayFileInfo> mapping = new ColumnPositionMappingStrategy<>();
            mapping.setType(PayFileInfo.class);
            CsvToBean<PayFileInfo> csvToBean = new CsvToBean<PayFileInfo>();
            CsvToBeanFilter csvToBeanFilter = new CSVToBeanFilter();
            csvToBean.setMappingStrategy(mapping);
            csvToBean.setCsvReader(reader);
            csvToBean.setFilter(csvToBeanFilter);
            Iterator<PayFileInfo> cit = csvToBean.iterator();
            while (cit.hasNext()){
                list.add(cit.next());
            }
        }else {
            log.info("无效的文件路径");
        }
        return  list;
    }

    /**
     * 创建文件
     * @param data  随意参数
     * @return
     */
    public File createFile(String data){
        //创建文件夹
        File file = new File("D:\\zazq");
        data = data + ContantsEnum.PAY_FILE_NAME.getDescFormat();
        if (!file.exists()){
            file.mkdirs();
        }
        //创建文件
        File filePath = new File(file,data+".txt");
        if(filePath.exists()){
            filePath.delete();
        }
        return filePath;
    }
}
