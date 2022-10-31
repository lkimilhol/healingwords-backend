package com.lkimilhol.healingwords.words.dto

data class ModifyWordsNonMemberDto(
    val id: Long,
    val password: String,
    val content: String
)