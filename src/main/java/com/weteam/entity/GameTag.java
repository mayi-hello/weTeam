package com.weteam.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class GameTag implements Serializable {
    private Integer id;

    private String tagName;

}