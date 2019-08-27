package com.kyrie.straptable.service;

import com.kyrie.straptable.entity.SysLog;
import com.kyrie.straptable.mapperr.SysLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysLogService
 * @Description
 * @Author Kyrie
 * @Date 2019/8/26 17:36
 * @Version 1.0
 **/
@Service
public class SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    public List<SysLog> getAllLogs(){
        return sysLogMapper.getAllLogs();
    }

    public SysLog selectByPrimaryKey(Long id){
        return  sysLogMapper.selectByPrimaryKey(id);
    }
}
