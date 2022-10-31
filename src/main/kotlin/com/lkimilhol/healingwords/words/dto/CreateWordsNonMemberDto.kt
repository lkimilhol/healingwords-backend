package com.lkimilhol.healingwords.words.dto

data class CreateWordsNonMemberDto(
    val author: String,
    val password: String,
    val email: String,
    val content: String
)