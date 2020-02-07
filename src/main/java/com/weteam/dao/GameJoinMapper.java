package com.weteam.dao;

import com.weteam.entity.GameJoin;
import java.util.List;

public interface GameJoinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameJoin record);

    GameJoin selectByPrimaryKey(Integer id);

    List<GameJoin> selectAll();

    int updateByPrimaryKey(GameJoin record);
}