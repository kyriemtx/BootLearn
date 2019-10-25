package com.kyrie.markdown;

import com.kyrie.markdown.entity.Content;
import com.kyrie.markdown.service.ContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MainTest
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/25 17:32
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarkDownApplication.class)
public class MainTest {

    @Autowired
    private ContentService contentService;

    @Test
    public void getList(){
        List<Content> list = new ArrayList<>();
        list = contentService.getList();
        int size = list.size();
        System.out.println("----------------------------------------------");
        System.err.println(size);

    }

}
