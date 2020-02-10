package com.weteam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties("password")
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name = "userName")

    private String username;

    private String password;

    @Column(name = "open_id")
    private String openId;

    private Byte gender;

    private String grade;

    private String academy;

    private String phone;

    private String email;

    private String personInfo;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "login_last_time")
    private Date loginLastTime;

}