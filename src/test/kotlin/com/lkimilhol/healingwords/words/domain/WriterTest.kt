package com.lkimilhol.healingwords.words.domain

import com.lkimilhol.healingwords.exception.WriterLengthExceedException
import io.kotlintest.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("작성자 테스트")
internal class WriterTest {

    @Test
    fun `생성 실패`() {
        // given
        // when
        // then
        Assertions.assertThatThrownBy { Writer.create("lkimilhollkimilhol") }
            .isInstanceOf(WriterLengthExceedException::class.java)
    }

    @Test
    fun `생성 성공`() {
        // given
        val name = "lkimilhol"

        // when
        val writer = Writer.create(name)

        // then
        writer.name() shouldBe name
    }
}