package com.weteam.mapper;

import com.weteam.model.domain.Award;

import java.util.List;

public interface IAwardDao {

    List<Award> findAwardByUserId(int id);
}
