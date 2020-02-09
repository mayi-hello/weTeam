package com.weteam.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @Column(name = "game_ddl")
    private String gameDdl;

    private String announce;

    private String source;

    private String notice;
    @Column(name = "file_url")
    private String fileUrl;
    @Column(name = "sign_form_url")
    private String signFormUrl;
    @Column(name = "team_size")
    private String teamSize;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl == null ? null : posterUrl.trim();
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getGameDdl() {
        return gameDdl;
    }

    public void setGameDdl(String gameDdl) {
        this.gameDdl = gameDdl == null ? null : gameDdl.trim();
    }

    public String getAnnounce() {
        return announce;
    }

    public void setAnnounce(String announce) {
        this.announce = announce == null ? null : announce.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getSignFormUrl() {
        return signFormUrl;
    }

    public void setSignFormUrl(String signFormUrl) {
        this.signFormUrl = signFormUrl == null ? null : signFormUrl.trim();
    }

    public String getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize == null ? null : teamSize.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", posterUrl=").append(posterUrl);
        sb.append(", postTime=").append(postTime);
        sb.append(", gameDdl=").append(gameDdl);
        sb.append(", announce=").append(announce);
        sb.append(", source=").append(source);
        sb.append(", notice=").append(notice);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", signFormUrl=").append(signFormUrl);
        sb.append(", teamSize=").append(teamSize);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}