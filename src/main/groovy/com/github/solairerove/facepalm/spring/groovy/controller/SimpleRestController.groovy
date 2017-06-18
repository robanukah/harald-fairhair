package com.github.solairerove.facepalm.spring.groovy.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = "/api")
class SimpleRestController {

    @GetMapping(path = "/quote")
    ResponseEntity<String> getQuote() {
        return ResponseEntity
                .ok()
                .body("Some Quote")
    }
}
