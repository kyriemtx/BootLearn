package com.kyrie.markdown.service;

import com.kyrie.markdown.entity.Content;
import com.kyrie.markdown.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ContentService
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/25 17:33
 **/
@Service
public class ContentService {

    @Autowired
    private ContentMapper contentMapper;

    public List<Content> getList(){
        List<Content> list = new ArrayList<>();
        list = contentMapper.getText();
        return list;
    }


    public int addText(Content content) {

        return contentMapper.addText(content);
    }
}
