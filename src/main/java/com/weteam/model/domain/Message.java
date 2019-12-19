package com.weteam.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Message<userId> implements Serializable {

    private int id;
    private Date createTime;
    private String content;
    private int userId;
}
