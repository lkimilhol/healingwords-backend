package com.lkimilhol.healingwords.writer.controller

import com.lkimilhol.healingwords.writer.dto.MemberAddDto
import com.lkimilhol.healingwords.writer.service.WriterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WriterController (
    private val writerService: WriterService,
){

    @PostMapping("/v1/writers")
    fun register(@RequestBody memberAddDto: MemberAddDto): ResponseEntity<String> {
        writerService.addMember(memberAddDto)
        return ResponseEntity.ok("OK")
    }
}