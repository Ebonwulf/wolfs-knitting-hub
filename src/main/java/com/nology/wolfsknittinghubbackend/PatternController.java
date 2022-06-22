package com.nology.wolfsknittinghubbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins  = {"https://wolfs-knitting-hub-5h356xxfoq-nw.a.run.app", "https://ebonwulf.github.io", "http://localhost:3000"} )
public class PatternController {

    @Autowired
    PatternRepository patternRepository;

    @GetMapping("/knitting-hub-frontend/pattern")
    public String getPattern(@PathVariable String patternName) {
        return patternName;
    }


    @GetMapping("/knitting-hub-frontend/patterns")
    public ResponseEntity<List<Pattern>>  getPatterns() {
       List<Pattern> listOfPatterns = this.patternRepository.findAll();
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(listOfPatterns);
    }


    @PostMapping("/knitting-hub-frontend/pattern")
    public String addPattern(@RequestBody Pattern text) {
        this.patternRepository.save(text);
        return "Pattern saved";

    }

    @DeleteMapping("/knitting-hub-frontend/pattern/{patternId}")
    @Transactional
    public String deletePattern(@PathVariable int patternId) {
        System.out.println("pattern = " + patternId);
        int deleted = this.patternRepository.deletePatternByPatternId(patternId);
        if (deleted > 0) {
            return "Pattern removed";
        }
        return "Pattern Id doesn't exist";
    }

    @PutMapping("/knitting-hub-frontend/pattern/{patternId}")
    public String updatePattern(@RequestBody Pattern text, @PathVariable int patternId) {
        System.out.println("pattern = " + patternId);
        this.patternRepository.save(text);
        return "Pattern updated";
    }
}
