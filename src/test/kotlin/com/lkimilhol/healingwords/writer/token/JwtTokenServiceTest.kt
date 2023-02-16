package com.lkimilhol.healingwords.writer.token

import com.lkimilhol.healingwords.writer.domain.Email
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

internal class JwtTokenServiceTest {
    private val secretKey = "wjfopwajfpoewjvpajfeoj310afjiaejfivjkowjfopwajfpoewjvpajfeoj310afjiaejfivjko"
    private val email = "test@email.com"
    private val jwtTokenService = JwtTokenService(secretKey)

    @Test
    fun `jwt 토큰 생성 테스트`() {
        val jwtToken = jwtTokenService.generateToken(Email.create(email))

        jwtTokenService.isValid(jwtToken) shouldBe true
    }
}