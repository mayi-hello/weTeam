package com.weteam.model.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tag implements Serializable {

    private int id;
    private String tagName;
    private String tagUrl;
}
