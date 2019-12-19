package com.weteam.model.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GameTag implements Serializable {

    private int gameId;
    private int tagId;
}
