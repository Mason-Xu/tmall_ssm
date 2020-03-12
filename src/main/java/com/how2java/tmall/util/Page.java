package com.how2java.tmall.util;

// 分页功能
public class Page {
    private int start;//开始位置
    private int count;//每页显示数量
    private int total;//总共多少数据
    String pararm;//参数,暂时用不到

    private static final int defaultCount=5;
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //Page()方法overload
    public Page(){
        count=defaultCount;
    }
    public Page(int start,int count){
        this();
        this.count = count;
        this.start = start;
    }

    //judge if it has previouse page?
    public boolean isHasPreviouse(){
        if(start==0)
            return false;
        return true;
    }
}
