package com.lkimilhol.healingwords.writer.controller

import com.lkimilhol.healingwords.writer.dto.WriterDto
import com.lkimilhol.healingwords.writer.service.WriterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WriterController(val writerService: WriterService) {

    @PostMapping("/writer")
    fun register(writerDto: WriterDto): ResponseEntity<WriterDto> {
       return ResponseEntity.ok().body(writerService.register(writerDto))
    }
}