package com.lkimilhol.healingwords.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.lkimilhol.healingwords.controller.dto.Words;

@RestController
@RequiredArgsConstructor
public class WordsController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<Words> getWords() {
        Words words = new Words("lkimilhol", "test");
        return ResponseEntity.ok(words);
    }
}
