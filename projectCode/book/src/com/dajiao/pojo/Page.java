package com.dajiao.pojo;

import java.util.List;

/**
 * @program: book
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-13 21:49
 **/
public class Page<T> {

    private static Integer pageSize = 4;
    private Integer pageNo;
    private Integer pageTotalCount;
    private Integer pageTotal;
    private List<T> pageBooks;
    private String url = "";


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotalCount, Integer pageTotal, List<T> pageBooks) {
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        if (pageNo < 1){
           pageNo = 1;
        }
        this.pageNo = pageNo;
        this.pageTotalCount = pageTotalCount;
        this.pageTotal = pageTotal;
        this.pageBooks = pageBooks;
    }

    public static Integer getPageSize() {
        return pageSize;
    }

    public static void setPageSize(Integer pageSize) {
        Page.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        if (pageNo < 1){
            pageNo = 1;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getPageBooks() {
        return pageBooks;
    }

    public void setPageBooks(List<T> pageBooks) {
        this.pageBooks = pageBooks;
    }

    @Override
    public String toString() {
        return "page{" +
                "pageNo=" + pageNo +
                ", pageTotalCount=" + pageTotalCount +
                ", pageTotal=" + pageTotal +
                ", pageBooks=" + pageBooks +
                '}';
    }
}
