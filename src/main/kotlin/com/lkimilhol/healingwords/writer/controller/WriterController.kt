package com.lkimilhol.healingwords.writer.controller

import com.lkimilhol.healingwords.writer.dto.WriterDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WriterController {

    @PostMapping("/writer")
    fun register(writerDto: WriterDto): ResponseEntity<String> {
        return ResponseEntity.ok("OK")
    }
}