package com.how2java.tmall.util;

// 分页功能
public class Page {
    private int start;//开始位置
    private int count;//每页显示数量
    private int total;//总共多少数据
    String param;//参数,暂时用不到

    private static final int defaultCount = 5;    // 默认每页显示5个

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
    public Page() {
        count = defaultCount;
    }

    public Page(int start, int count) {
        //super()和this()类似,区别是，super()从子类中调用父类的构造方法，this()在同一类内调用其它方法。
        super();
        this.start = start;
        this.count = count;
    }

    //judge if it has previouse page?
    public boolean isHasPreviouse() {
        if (start == 0)
            return false;
        return true;
    }

    public boolean isHasNext() {
        if (start == getLast())
            return false;
        return true;
    }

    public int getTotalPage() {
        int totalPage;
        //假设总数是50,是能被5整除的,那么就有十页
        if (0 == total % count)
            totalPage = total / count;
        else
            //不能被count整除的,商+1
            totalPage = total / count + 1;

        if (0 == totalPage)
            totalPage = 1;
        return totalPage;
    }


    public int getLast() {
        int last;
        if (0 == total % count)
            //能被count整除的,最后一页的开始是total-count
            last = total - count;
        else
            //不能整除的,total - total % count;
            last = total - total % count;
        //last = last < 0 ? 0 : last;
        last = Math.max(last, 0);
        return last;
    }

    @Override
    public String toString() {
        return "Page [start=" + start + ", count=" + count + ", total=" + total + ", getStart()=" + getStart()
                + ", getCount()=" + getCount() + ", isHasPreviouse()=" + isHasPreviouse() + ", isHasNext()="
                + isHasNext() + ", getTotalPage()=" + getTotalPage() + ", getLast()=" + getLast() + "]";
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
