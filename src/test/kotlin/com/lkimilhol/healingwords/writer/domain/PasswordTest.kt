package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.exception.PasswordLengthExceedException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class PasswordTest {

    @Test
    fun `생성 실패`() {
        // given
        // when
        // then
        assertThatThrownBy {Password.create("passwordpasswordpasswordpasswordpassword")}
            .isInstanceOf(PasswordLengthExceedException::class.java)
    }

    @Test
    fun `생성`() {
        // given
        val password = Password.create("password")
        // when
        // then
        assertThat(password.contents()).isEqualTo("password")
    }
}