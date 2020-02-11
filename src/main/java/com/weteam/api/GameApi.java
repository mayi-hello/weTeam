package com.weteam.api;

import com.weteam.entity.Game;
import com.weteam.repository.GameRepository;
import com.weteam.repository.GameTagRecordRepository;
import com.weteam.utils.BasicException;
import com.weteam.utils.BasicResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/game/api")
public class GameApi {

    @Resource
    GameRepository gameRepository;
    @Resource
    GameTagRecordRepository gameTagRecordRepository;

    @PostMapping("/source/{source}")
    public ResponseEntity findAllGame(@PathVariable String source,
                                       @RequestParam(defaultValue = "0") Integer page,
                                       @RequestParam(defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"postTime"));
        List<Game> games = gameRepository.findBySource(source, pageable).getContent();
        return ResponseEntity.ok(BasicResponse.ok().data(games));
    }

    @PostMapping("/search/{cond}")
    public ResponseEntity searchGame(@RequestParam String param,
                                     @RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "10") Integer size,
                                     @PathVariable("cond") String condition) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"postTime"));
        List<Game> games = new ArrayList<>();
        param = "%" + param + "%";
        switch (condition) {
            case "source":
                games = gameRepository.findBySourceLike(param, pageable).getContent();
                break;
            case "name":
                games = gameRepository.findByNameLike(param, pageable).getContent();
                break;
            case "tag":
                List<Integer> ids = gameTagRecordRepository.findByTagName(param);
                for(int i: ids){
                    Game game = gameRepository.findById(i).orElse(null);
                    if(game != null)
                        games.add(game);
                }
                games.sort(Comparator.comparing(Game::getPostTime));
                break;
        }
        return ResponseEntity.ok(BasicResponse.ok().data(games));
    }

    @PostMapping("/info")
    public ResponseEntity getInfo(@RequestParam Integer id){
        Game game = gameRepository.findById(id).orElse(null);
        if(game == null)
            return ResponseEntity.ok().body(BasicResponse.ok().data("nothing"));
        return ResponseEntity.ok().body(BasicResponse.ok().data(game));
    }
}
