package com.weteam.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Attention implements Serializable {

    private Integer userId;

    private Integer attentionUserId;
}
