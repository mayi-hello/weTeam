package com.weteam.api;

import com.weteam.entity.*;
import com.weteam.repository.*;
import com.weteam.utils.BasicResponse;
import com.weteam.utils.SessionHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

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
    @Resource
    AwardRepository awardRepository;

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
        List<Message> messages = messageRepository.findByReceiverId(id, pageable).getContent();
        return ResponseEntity.ok(BasicResponse.ok().data(messages));
    }

    @PostMapping("games/{id}")
    public ResponseEntity findGames(@PathVariable Integer id){
        List<GameJoin> gameJoins = gameJoinRepository.findByUserId(id);
        List<Integer> teamIds = new ArrayList<>();
        List<Game> games = new ArrayList<>();
        for(GameJoin gameJoin: gameJoins){
            Game game = gameRepository.findById(gameJoin.getGameId()).orElse(null);
            if(game!=null) {
                games.add(game);
                teamIds.add(gameJoin.getGameTeamId());
            }
        }
        games.sort(Comparator.comparing(Game::getPostTime));
        if (games.size() == 0)
            return ResponseEntity.ok(BasicResponse.ok().data("nothing"));
        return ResponseEntity.ok(BasicResponse.ok().data(games).data(teamIds));
    }

    @PostMapping("award")
    public ResponseEntity getAward(@RequestParam Integer id){
        List<Award> awards = awardRepository.findByUserId(id);
        if(awards.size() == 0)
            return ResponseEntity.ok(BasicResponse.ok().data("nothing"));
        return ResponseEntity.ok(BasicResponse.ok().data(awards));
    }

    @PostMapping("info/modification")
    public ResponseEntity modifyInfo(@RequestParam Integer id,
                                     @RequestParam Map<String,Object> params){
        User user = userRepository.findById(id).orElse(null);
        if(user!=null)
            if(params.size()!=0)
                for(String key: params.keySet()){
                    try{
                    setFieldValueByFieldName(key,params.get(key),User.class,Object.class);
                    }catch (Exception e){
                        return ResponseEntity.ok(BasicResponse.fail());
                    }
                }
        return ResponseEntity.ok(BasicResponse.ok());
    }

    public static void setFieldValueByFieldName(String fieldName,Object fieldValue,Object object,Class<?>... parameterTypes) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String name = fields[i].getName();
            if (name.equals(fieldName)) {
                field.setAccessible(true);
                String methname = name.substring(0, 1).toUpperCase() + name.substring(1);
                Method m = object.getClass().getMethod("set" + methname, parameterTypes);
                m.invoke(object, fieldValue);
            }
        }
    }
}
