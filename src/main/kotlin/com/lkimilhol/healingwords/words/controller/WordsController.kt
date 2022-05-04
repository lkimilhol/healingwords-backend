package com.lkimilhol.healingwords.words.controller

import com.lkimilhol.healingwords.words.dto.WordsDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WordsController {

    @GetMapping("/words")
    fun getWords() : ResponseEntity<WordsDto> {
        val wordsDTO = WordsDto("lkimilhol", "test")
        return ResponseEntity.ok(wordsDTO)
    }
}
