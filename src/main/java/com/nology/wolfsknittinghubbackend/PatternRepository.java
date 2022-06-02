package com.nology.wolfsknittinghubbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatternRepository extends JpaRepository<Pattern, Integer> {

    int deletePatternByPatternId(int patternId);
}
