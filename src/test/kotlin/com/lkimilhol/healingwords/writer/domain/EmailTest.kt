package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.writer.exception.EmailLengthExceedException
import com.lkimilhol.healingwords.writer.exception.InvalidEmailFormException
import io.kotlintest.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class EmailTest {
    @Test
    fun `생성 실패 - ID가 너무 김`() {
        // given
        // when
        // then
        assertThatThrownBy {
            Email.create("lkimilhollkimilhollkimilhol@healingwords.com")
        }.isInstanceOf(EmailLengthExceedException::class.java)
    }

    @Test
    fun `생성 실패 - email 형식이 아님`() {
        // given
        // when
        // then
        assertThatThrownBy {
            Email.create("lkimilhol")
        }.isInstanceOf(InvalidEmailFormException::class.java)
    }

    @Test
    fun `생성`() {
        // given
        val email = Email.create("lkimilhol@healingwords.com")

        // when
        // then
        email.contents() shouldBe "lkimilhol@healingwords.com"
    }
}