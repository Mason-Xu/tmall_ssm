package com.how2java.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("admin_user_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());

        List<User> us = userService.list();

        //修改list方法
        //1. 通过分页插件指定分页参数
        //PageHelper.offsetPage(page.getStart(),page.getCount());
        //2. 调用list() 获取对应分页的数据
        //categoryService.list();
        //3. 通过PageInfo获取总数
        // int total = (int) new PageInfo<>(cs).getTotal();
        int total = (int) new PageInfo<>(us).getTotal();
        //通过page.setTotal(total); 为分页对象设置总数
        page.setTotal(total);

        model.addAttribute("us", us);
        model.addAttribute("page", page);

        return "admin/listUser";
    }
}
