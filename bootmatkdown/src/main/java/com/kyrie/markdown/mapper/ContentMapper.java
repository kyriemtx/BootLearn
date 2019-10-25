package com.kyrie.markdown.mapper;
import com.kyrie.markdown.entity.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import	java.util.Map;

/**
 * @ClassName ContentMapper
 * @Description
 * @Author tengxiao.ma
 * @Date 2019/10/25 17:27
 **/
@Mapper
public interface ContentMapper {

    /**
     * 获取集合
     * @return
     */
    List<Content> getText();

    /**
     * 新增文章
     * @param content
     * @return
     */
    int addText(Content content);
}
