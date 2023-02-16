package com.lkimilhol.healingwords.writer.token

data class JwtToken (
    val grantType: String,
    val accessToken: String,
    val refreshToken: String
)