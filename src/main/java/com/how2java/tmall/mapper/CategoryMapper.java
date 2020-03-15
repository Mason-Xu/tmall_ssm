package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
    //查询方法list
    public List<Category> list(Page page);

    //获取总数total
    public int total();
}
