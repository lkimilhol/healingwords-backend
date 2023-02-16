package com.lkimilhol.healingwords.writer.controller

import com.lkimilhol.healingwords.writer.dto.request.WriterAddRequest
import com.lkimilhol.healingwords.writer.dto.request.WriterLoginRequest
import com.lkimilhol.healingwords.writer.dto.response.WriterLoginResponse
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
    fun register(@RequestBody writerAddRequest: WriterAddRequest): ResponseEntity<String> {
        writerService.addMember(writerAddRequest)
        return ResponseEntity.ok("OK")
    }

    @PostMapping("/v1/writers/login")
    fun login(@RequestBody writerLoginRequest: WriterLoginRequest) : ResponseEntity<WriterLoginResponse> {
        val jwt = writerService.login(writerLoginRequest)
        return ResponseEntity.ok(WriterLoginResponse(jwt))
    }
}