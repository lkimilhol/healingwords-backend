package words.controller

import com.lkimilhol.healingwords.words.dto.WordsDto
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class WordsController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getWords() : ResponseEntity<WordsDto> {
        val wordsDTO = WordsDto("lkimilhol", "test")
        return ResponseEntity.ok(wordsDTO)
    }
}