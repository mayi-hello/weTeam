package com.weteam.mapper;

import com.weteam.model.domain.Game;

import java.util.List;
import java.util.Map;

public interface IGameDao {

    int findCountGameWithTag(Map<String, Object> map);

    List<Game> findAllGameWithTag(Map<String, Object> map);

    int findCountGameByUserId(Map<String, Object> map);

    List<Game> findAllGameByUserId(Map<String, Object> map);

    List<Game> findAll();

    Game findGameById(int gameId);


}
