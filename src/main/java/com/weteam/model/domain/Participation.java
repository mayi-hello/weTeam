package com.weteam.model.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Participation implements Serializable {

    private int id;
    private int userId;
    private int gameId;

}
