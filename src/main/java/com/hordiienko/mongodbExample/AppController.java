package com.hordiienko.mongodbExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start_app")
public class AppController {
    @Autowired
    private MongoDocService mongoDocService;

    @GetMapping("/add")
    public String startApp() {
        mongoDocService.run();
        return "ok";
    }
}
