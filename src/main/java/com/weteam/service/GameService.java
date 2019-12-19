package com.weteam.service;

import com.weteam.model.domain.Game;
import com.weteam.model.dto.PageBean;

import java.util.List;
import java.util.Map;

public interface GameService {

    PageBean<Game> findAllGameByPage(int currentPage, int rows, String key);

    List<Game> findAll();

    PageBean<Game> findAllGameByUserId(int currentPage, int rows, String key, int userId);
}
