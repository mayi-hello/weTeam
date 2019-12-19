package com.weteam.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 */
@Data
public class User implements Serializable {

    private int id;
    private String name;
    private String userName;
    private String password;
    private int gender;
    private String grade;
    private String academy;
    private String phone;
    private String email;
    private String personInfo;
    private String avatarImgUrl;
    private Date loginLastTime;
}
