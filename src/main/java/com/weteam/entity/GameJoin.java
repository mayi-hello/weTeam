package com.weteam.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "game_join")
public class GameJoin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "game_id")
    private Integer gameId;
    @Column(name = "game_team_id")
    private Integer gameTeamId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getGameTeamId() {
        return gameTeamId;
    }

    public void setGameTeamId(Integer gameTeamId) {
        this.gameTeamId = gameTeamId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", gameId=").append(gameId);
        sb.append(", gameTeamId=").append(gameTeamId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}