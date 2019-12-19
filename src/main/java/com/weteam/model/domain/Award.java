package com.weteam.model.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Award implements Serializable {

    private int id;
    private String name;
    private int userId;
}

