package com.weteam.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Game implements Serializable {

    private int id;
    private String name;
    private Date postTime;
    private String announce;
    private String notice;
    private String fileUrl;
    private String signFormUrl;
    private List<Tag> tag;

}
