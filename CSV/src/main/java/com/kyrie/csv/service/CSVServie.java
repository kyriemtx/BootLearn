package com.kyrie.csv.service;

import com.kyrie.csv.comm.CommEnum;
import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @ClassName CSVReaderServie
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/10 18:12
 **/
@Service
@Slf4j
public class CSVServie {

    String Encoding = "UTF-8";
    File filePath = null;
    String split = "|";

    public File createFile() {
        //创建文件
        File file = new File(CommEnum.FILE_DIR.getDescFormat());
        if (!file.exists()) {
            file.mkdirs();
        }
        filePath = new File(file, CommEnum.FILE_PATH.getDescFormat() + ".txt");
        return filePath;
    }

    public void csvWrite(File filePath, String split, String encoding) {
        try {
            Writer writer = new FileWriter(filePath);
            CSVWriter csvWriter = new CSVWriter(writer, '|');
            //写表头
            String[] header = {"编号", "姓名", "年龄"};
            csvWriter.writeNext(header);
        } catch (IOException e) {
            log.info("文件写入失败");
            return;
        }
    }

    public void csv() throws IOException {
        File filePath = this.createFile();
        this.csvWrite(filePath, split, Encoding);
    }
}
