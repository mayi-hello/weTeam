package com.weteam.model.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class registerRecord implements Serializable {

    private int id;
    private int gameId ;
    private int userId;

}
