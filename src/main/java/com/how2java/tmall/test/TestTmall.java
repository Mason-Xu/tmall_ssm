package com.how2java.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//这里使用的是jdbc连接数据库创建测试数据
public class TestTmall {
    public static void main(String[] args) {
        // 准备分类测试数据

        try {
//          初始化驱动类com.mysql.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功 ！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
//          建立与数据库的Connection连接
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf8",
                        "root", "admin");
                Statement s = c.createStatement();
//          Statement是用于执行SQL语句的，比如增加，删除
//          注意：使用的是 java.sql.Statement
//          不要不小心使用到： com.mysql.jdbc.Statement;
        ) {
            for (int i = 1; i <= 10; i++) {
                String sqlFormat = "insert into category values (null,'测试分类%d')";
                String sql = String.format(sqlFormat, i);
//              s.execute执行sql语句
                s.execute(sql);
            }
            System.out.println("已经成功创建10条分类测试数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
