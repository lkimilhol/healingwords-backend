package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.writer.exception.NameLengthExceedException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class NameTest {
    @Test
    fun `생성 실패`() {
        // given
        // when
        // then
        assertThatThrownBy {
            Name.create("namenamename")
        }.isInstanceOf(NameLengthExceedException::class.java)
    }

    @Test
    fun `생성 성공`() {
        // given
        // when
        val name = Name.create("name")

        // then
        assertThat(name.content()).isEqualTo("name")
    }
}