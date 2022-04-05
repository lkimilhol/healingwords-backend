package com.lkimilhol.healingwords.words.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.lkimilhol.healingwords.words.dto.WordsDto;

@RestController
@RequiredArgsConstructor
public class WordsController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<WordsDto> getWords() {
        WordsDto wordsDTO = new WordsDto("lkimilhol", "test");
        return ResponseEntity.ok(wordsDTO);
    }
}
