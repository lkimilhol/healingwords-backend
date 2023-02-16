package com.lkimilhol.healingwords.writer.token

import com.lkimilhol.healingwords.writer.domain.Email
import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import java.util.*

internal class JwtTokenServiceTest {
    private val secretKey = "wjfopwajfpoewjvpajfeoj310afjiaejfivjkowjfopwajfpoewjvpajfeoj310afjiaejfivjko"
    private val email = "test@email.com"
    private val jwtTokenService = JwtTokenService(secretKey)

    @Test
    fun `jwt_토큰_생성_테스트`() {
        val jwtToken = jwtTokenService.generateToken(Email.create(email))

        jwtTokenService.isValid(jwtToken) shouldBe true
    }
}