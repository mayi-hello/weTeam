package com.weteam.api;

import com.weteam.entity.Game;
import com.weteam.entity.GameJoin;
import com.weteam.entity.Message;
import com.weteam.entity.User;
import com.weteam.repository.GameJoinRepository;
import com.weteam.repository.GameRepository;
import com.weteam.repository.MessageRepository;
import com.weteam.repository.UserRepository;
import com.weteam.utils.BasicResponse;
import com.weteam.utils.SessionHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/api")
public class UserApi {

    @Resource
    SessionHelper sessionHelper;

    @Resource
    UserRepository userRepository;
    @Resource
    MessageRepository messageRepository;
    @Resource
    GameJoinRepository gameJoinRepository;
    @Resource
    GameRepository gameRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestParam("username") String username,
                                                @RequestParam("password") String password,
                                                HttpSession session){
        try {
            User user = sessionHelper.login(session, username, password);
            //User user = userRepository.findByUsername(username);
            return ResponseEntity.ok().body(BasicResponse.ok().message("登录成功").data(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BasicResponse.fail().message(e.getMessage()));
        }
    }

    @PostMapping("/message/{id}")
    public ResponseEntity findMessages(@PathVariable Integer id,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"createTime"));
        List<Message> messages = messageRepository.findByUserId(id, pageable).getContent();
        return ResponseEntity.ok(BasicResponse.ok().data(messages));
    }

    @PostMapping("games/{id}")
    public ResponseEntity findGames(@PathVariable Integer id){
        List<GameJoin> gameJoins = gameJoinRepository.findByUserId(id);
        List<Game> games = new ArrayList<>();
        for(GameJoin gameJoin: gameJoins){
            Game game = gameRepository.findById(gameJoin.getGameId()).orElse(null);
            if(game!=null)
                games.add(game);
        }
        if (games.size() == 0)
            return ResponseEntity.ok(BasicResponse.ok().data("nothing"));
        return ResponseEntity.ok(BasicResponse.ok().data(games));
    }
}
