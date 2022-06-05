package com.nology.wolfsknittinghubbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class PatternController {

    @Autowired
    PatternRepository patternRepository;

    @GetMapping("/pattern")
    public String getPattern() {
        return "getting pattern";
    }

    @GetMapping("/patterns")
    public List<Pattern> getPatterns() {
       return patternRepository.findAll();
    }

    @PostMapping("/pattern")
    public String addPattern(@RequestBody Pattern text) {
        this.patternRepository.save(text);
        return "Pattern saved";

    }

    @DeleteMapping("/pattern/{patternId}")
    @Transactional
    public String deletePattern(@PathVariable int patternId) {
        System.out.println("pattern = " + patternId);
        int deleted = this.patternRepository.deletePatternByPatternId(patternId);
        if (deleted > 0) {
            return "Pattern removed";
        }
        return "Pattern Id doesn't exist";
    }
}
