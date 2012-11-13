package com.beauty.core.web.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.beauty.core.util.Constant;

public class Page implements Serializable
{
    private static final long serialVersionUID = 8598121861228542602L;

    //当前页码
    private int currentPageNo;
    
    //每页显示记录数
    private int pageSize;
    
    //总记录数
    private long totalCount;

    //总页面数
    private long totalPageCount;
    
    //分页查询时的开始条数
    private int firstResult;
    
    //也pageSize相同,供hibernate分页使用
    private int maxResults;
    
    //每页显示分页按钮数
    private int limit;
    
    //页面中可选择每页显示多少条记录
    private String listPageSize;
    
    //保存查询返回结果集
    private List<Object> result = new ArrayList<Object>();

    /**
    * 
    * <p>Title: </p> 
    * <p>Description: 初始化分页参数</p>
    */
    public Page()
    {
        currentPageNo = Constant.PAGE_DEFAULT_CURRENT_NO;
        pageSize = Constant.PAGE_DEFAULT_PAGE_SIZE;
        limit = Constant.PAGE_DEFAULT_LIMIT;
        listPageSize = Constant.PAGE_DEFAULT_LIST_PAGE_SIZE;
    }

    public Page(int currentPageNo, int pageSize, List<Object> result, long totalCount)
    {
        super();
        this.currentPageNo = currentPageNo;
        this.pageSize = pageSize;
        this.result = result;
        this.totalCount = totalCount;
    }

    public int getCurrentPageNo()
    {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo)
    {
        this.currentPageNo = currentPageNo;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }

    public long getTotalPageCount()
    {
        if(pageSize == 0)
        {
            pageSize = Constant.PAGE_DEFAULT_PAGE_SIZE;
        }
        this.totalPageCount = (totalCount+pageSize-1)/pageSize;
        return totalPageCount;
    }

    public void setTotalPageCount(long totalPageCount)
    {
        this.totalPageCount = totalPageCount;
    }

    public List<Object> getResult()
    {
        return result;
    }

    public void setResult(List<Object> result)
    {
        this.result = result;
    }

    public int getFirstResult() {
        
        this.firstResult = pageSize * (currentPageNo - 1);
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getMaxResults() {
        this.maxResults = pageSize;
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getListPageSize() {
        return listPageSize;
    }

    public void setListPageSize(String listPageSize) {
        this.listPageSize = listPageSize;
    }
    
}
