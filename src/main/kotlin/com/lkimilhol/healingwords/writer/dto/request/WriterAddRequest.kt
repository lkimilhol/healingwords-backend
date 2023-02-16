package com.lkimilhol.healingwords.writer.dto.request

data class WriterAddRequest(
    val nickname: String,
    val password: String,
    val email: String
)