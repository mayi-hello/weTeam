package com.weteam.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class GameTagRecord implements Serializable {
    private Integer gameId;

    private Integer tagId;

}