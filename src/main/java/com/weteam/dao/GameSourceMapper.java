package com.weteam.dao;

import com.weteam.entity.GameSource;
import java.util.List;

public interface GameSourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameSource record);

    GameSource selectByPrimaryKey(Integer id);

    List<GameSource> selectAll();

    int updateByPrimaryKey(GameSource record);
}