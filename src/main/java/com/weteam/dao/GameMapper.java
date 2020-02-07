package com.weteam.dao;

import com.weteam.entity.Game;
import java.util.List;

public interface GameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Game record);

    Game selectByPrimaryKey(Integer id);

    List<Game> selectAll();

    int updateByPrimaryKey(Game record);
}