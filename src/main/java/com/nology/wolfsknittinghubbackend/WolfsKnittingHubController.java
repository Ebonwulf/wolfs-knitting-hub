package com.nology.wolfsknittinghubbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WolfsKnittingHubController {

    @GetMapping("/message")
    public String getPattern() {
        return "knitting patterns library";
    }
}
