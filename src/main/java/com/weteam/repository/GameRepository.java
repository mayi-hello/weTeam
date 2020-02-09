package com.weteam.repository;

import com.weteam.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Page<Game> findBySource(String source, Pageable pageable);
    Page<Game> findBySourceLike(String param, Pageable pageable);
    Page<Game> findByNameLike(String param, Pageable pageable);
}
