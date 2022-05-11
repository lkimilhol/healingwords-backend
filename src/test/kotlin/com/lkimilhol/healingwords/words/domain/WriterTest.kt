package com.lkimilhol.healingwords.words.domain

import com.lkimilhol.healingwords.writer.domain.Email
import com.lkimilhol.healingwords.writer.domain.Name
import com.lkimilhol.healingwords.writer.domain.Password
import com.lkimilhol.healingwords.writer.domain.Writer
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

        // when
        val writer = Writer.create(
            Name.create(name),
            Password.create(password),
            Email.create(email)
        )

        // then
        writer.name() shouldBe name
        writer.password() shouldBe password
        writer.email() shouldBe email
    }
}