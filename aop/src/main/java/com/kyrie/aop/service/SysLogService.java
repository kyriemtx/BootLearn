package com.kyrie.aop.service;

import com.kyrie.aop.entity.SysLog;
import com.kyrie.aop.mapperr.SysLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysLogService
 * @Description
 * @Author Kyrie
 * @Date 2019/8/22 15:38
 * @Version 1.0
 **/
@Service
public class SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    public  void  saveSysLog(SysLog sysLog){
        sysLogMapper.saveSysLog(sysLog);
    }
}
