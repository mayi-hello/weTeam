package com.weteam.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Award implements Serializable {
    private Integer id;

    private String name;

    private String level;

    private String desc;

    private String paper_url;

    private Integer userId;



}