package com.weteam.dao;

import com.weteam.entity.Award;
import java.util.List;

public interface AwardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Award record);

    Award selectByPrimaryKey(Integer id);

    List<Award> selectAll();

    int updateByPrimaryKey(Award record);
}