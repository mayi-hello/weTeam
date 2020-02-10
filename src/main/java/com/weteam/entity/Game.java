package com.weteam.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "post_time")
    private Date postTime;

    @Column(name = "register_time")
    private Date registerTime;

    @Column(name = "game_ddl")
    private Date gameDdl;

    private String announce;

    private String source;

    private String notice;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "sign_form_url")
    private String signFormUrl;

    @Column(name = "team_size")
    private String teamSize;
}