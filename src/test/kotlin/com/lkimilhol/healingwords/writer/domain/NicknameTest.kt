package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.writer.exception.NicknameLengthExceedException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class NicknameTest {
    @Test
    fun `생성 실패`() {
        // given
        // when
        // then
        assertThatThrownBy {
            Nickname.create("namenamename")
        }.isInstanceOf(NicknameLengthExceedException::class.java)
    }

    @Test
    fun `생성 성공`() {
        // given
        // when
        val nickName = Nickname.create("name")

        // then
        assertThat(nickName.content()).isEqualTo("name")
    }
}