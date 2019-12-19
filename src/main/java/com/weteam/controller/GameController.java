package com.weteam.controller;


import com.weteam.mapper.IGameDao;
import com.weteam.model.domain.Game;
import com.weteam.model.dto.PageBean;
import com.weteam.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// @Controller
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;
    @Autowired
    IGameDao gameDao;

    /**
     * 分页查找所有比赛 & 标签
     * @param currentPage
     * @param rows
     * @param key
     * @param model
     * @return
     */
    @RequestMapping("/findAllGameWithTag")
    public PageBean<Game> findAllGameWithTag(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                             @RequestParam(value = "rows", defaultValue = "10") int rows,
                                             @RequestParam(value = "key", defaultValue = "") String key, Model model){

        PageBean<Game> gameList = gameService.findAllGameByPage(currentPage, rows, key);
        System.out.println(gameList);
        model.addAttribute("pb", gameList);
        return gameList;
    }

    /**
     * 根据gameId查找比赛详细信息
     * @param gameId
     * @param model
     * @return
     */
    @RequestMapping(value = "/findGameById/{gameId}", method = RequestMethod.GET)
    public Game findGameById(@PathVariable int gameId, Model model){

        Game game = gameDao.findGameById(gameId);
        System.out.println(game);
        return game;
    }

    /**
     * 查找一个用户所参加的比赛
     * @param currentPage
     * @param rows
     * @param userId
     * @param key
     * @param model
     * @return
     */
    @RequestMapping("/findAllGameByUserId")
    public PageBean<Game> findAllGameByUserId(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                             @RequestParam(value = "rows", defaultValue = "10") int rows,
                                              @RequestParam(value = "userId", defaultValue = "") int userId,
                                             @RequestParam(value = "key", defaultValue = "") String key, Model model){

        PageBean<Game> gameList = gameService.findAllGameByUserId(currentPage, rows, key, userId);
        System.out.println(gameList);
        model.addAttribute("pb", gameList);
        return gameList;
    }
}
