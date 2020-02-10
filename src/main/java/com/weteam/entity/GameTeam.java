package com.weteam.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class GameTeam implements Serializable {
    private Integer id;

    private Integer gameId;

}