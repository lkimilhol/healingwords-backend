package com.lkimilhol.healingwords.words.controller

import com.lkimilhol.healingwords.token.LoginCheck
import com.lkimilhol.healingwords.words.dto.WordsDto
import com.lkimilhol.healingwords.words.dto.WriteWordsDto
import com.lkimilhol.healingwords.words.service.WordsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WordsController(
    private val wordsService: WordsService,
) {

    @GetMapping("/words")
    fun getWords() : ResponseEntity<WordsDto> {
        val wordsDTO = WordsDto("lkimilhol", "test")
        return ResponseEntity.ok(wordsDTO)
    }

    @LoginCheck
    @PostMapping("/words")
    fun writeWords(@RequestBody wordsDto: WriteWordsDto) : ResponseEntity<String> {
        wordsService.write(wordsDto)
        return ResponseEntity.ok("OK")
    }

//    @PatchMapping("")
//    fun modifyWords(wordsDto: ModifyWordsNonMemberDto) : ResponseEntity<String> {
//        wordsService.modifyWithNonMember(wordsDto)
//        return ResponseEntity.ok("OK")
//    }
}
