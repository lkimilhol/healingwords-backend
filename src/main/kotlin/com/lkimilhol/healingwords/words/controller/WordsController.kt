//package com.lkimilhol.healingwords.words.controller
//
//import com.lkimilhol.healingwords.words.dto.WordsDto
//import com.lkimilhol.healingwords.words.dto.CreateWordsNonMemberDto
//import com.lkimilhol.healingwords.words.dto.ModifyWordsNonMemberDto
//import com.lkimilhol.healingwords.words.service.WordsService
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PatchMapping
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController("/words")
//class WordsController(
//    private val wordsService: WordsService
//) {
//
//    @GetMapping("")
//    fun getWords() : ResponseEntity<WordsDto> {
//        val wordsDTO = WordsDto("lkimilhol", "test")
//        return ResponseEntity.ok(wordsDTO)
//    }
//
//    @PostMapping("")
//    fun writeWords(wordsDto: CreateWordsNonMemberDto) : ResponseEntity<String> {
//        wordsService.writeWithNonMember(wordsDto)
//        return ResponseEntity.ok("OK")
//    }
//
//    @PatchMapping("")
//    fun modifyWords(wordsDto: ModifyWordsNonMemberDto) : ResponseEntity<String> {
//        wordsService.modifyWithNonMember(wordsDto)
//        return ResponseEntity.ok("OK")
//    }
//}
