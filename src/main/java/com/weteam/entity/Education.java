package com.weteam.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Education implements Serializable {
    private Integer id;

    private String school;

    private String major;

    private Date enterTime;

    private Date graduateTime;

    private Integer userId;
}
