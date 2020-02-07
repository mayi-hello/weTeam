package com.weteam.dao;

import com.weteam.entity.GameTagRecord;
import java.util.List;

public interface GameTagRecordMapper {
    int insert(GameTagRecord record);

    List<GameTagRecord> selectAll();
}