package com.lkimilhol.healingwords.words.domain

import com.lkimilhol.healingwords.writer.domain.*
import io.kotlintest.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("작성자 테스트")
internal class WriterTest {

    @Test
    fun `생성 성공`() {
        // given
        val name = "lkimilhol"
        val password = "password"
        val email = "lkimilhol@healingwords.com"
        val writerAuth = WriterAuth.MEMBER

        // when
        val writer = Writer.create(
            Nickname.create(name),
            Password.create(password),
            Email.create(email),
            writerAuth
        )

        // then
        writer.nickname() shouldBe name
        writer.password() shouldBe password
        writer.email() shouldBe email
        writer.auth() shouldBe WriterAuth.MEMBER
    }
}