package com.weteam.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private int totalCount;         //总记录数
    private int totalPage;          //总页码数 = 总记录数 % 每页显示条数 == 0 ？ 取整否则+1
    private List<T> list;           //每页的数据 list集合
    private int currentPage;        //当前页
    private int rows;               //每条显示的条数
}
