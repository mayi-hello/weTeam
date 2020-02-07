package com.weteam.dao;

import com.weteam.entity.GameTag;
import java.util.List;

public interface GameTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameTag record);

    GameTag selectByPrimaryKey(Integer id);

    List<GameTag> selectAll();

    int updateByPrimaryKey(GameTag record);
}