package com.weteam.repository;

import com.weteam.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardRepository extends JpaRepository<Award, Integer> {
    List<Award> findByUserId(Integer id);
}
