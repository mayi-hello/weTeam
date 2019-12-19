package com.weteam.service.impl;

import com.weteam.mapper.IGameDao;
import com.weteam.model.domain.*;
import com.weteam.model.dto.PageBean;
import com.weteam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private IGameDao matchDao;

    @Override
    public PageBean<Game> findAllGameByPage(int currentPage, int rows, String key) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        PageBean<Game> pageBean = new PageBean<Game>();

        //封装当前页数
        pageBean.setCurrentPage(currentPage);

        //每页显示页数
        pageBean.setRows(rows);

        //总记录数
        int totalCount = matchDao.findCountGameWithTag(map);
        pageBean.setTotalCount(totalCount);

        //总页数
        double tc = totalCount;
        Double num = Math.ceil(tc/rows);    //向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start", (currentPage-1)*rows);
        map.put("size", pageBean.getRows());

        //封装每页显示的数据
        List<Game> list = matchDao.findAllGameWithTag(map);
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public PageBean<Game> findAllGameByUserId(int currentPage, int rows, String key, int userId) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        map.put("userId", userId);
        PageBean<Game> pageBean = new PageBean<Game>();

        //封装当前页数
        pageBean.setCurrentPage(currentPage);

        //每页显示页数
        pageBean.setRows(rows);

        //总记录数
        int totalCount = matchDao.findCountGameByUserId(map);
        pageBean.setTotalCount(totalCount);

        //总页数
        double tc = totalCount;
        Double num = Math.ceil(tc/rows);    //向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start", (currentPage-1)*rows);
        map.put("size", pageBean.getRows());

        //封装每页显示的数据
        List<Game> list = matchDao.findAllGameByUserId(map);
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public List<Game> findAll() {
        return null;
    }

}
