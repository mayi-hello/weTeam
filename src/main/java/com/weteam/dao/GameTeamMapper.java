package com.weteam.dao;

import com.weteam.entity.GameTeam;
import java.util.List;

public interface GameTeamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameTeam record);

    GameTeam selectByPrimaryKey(Integer id);

    List<GameTeam> selectAll();

    int updateByPrimaryKey(GameTeam record);
}