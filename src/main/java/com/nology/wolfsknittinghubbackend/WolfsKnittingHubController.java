package com.nology.wolfsknittinghubbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WolfsKnittingHubController {

    @GetMapping("/pattern")
    public String getPattern() {
        return "knitting pattern loaded";
    }
}
