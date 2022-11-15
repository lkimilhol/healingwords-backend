package com.lkimilhol.healingwords.writer.service

import com.lkimilhol.healingwords.writer.dto.MemberAddDto
import com.lkimilhol.healingwords.writer.exception.AlreadyMemberException
import com.lkimilhol.healingwords.writer.exception.DuplicateNicknameException
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class WriterServiceTest {
    private val writerRepository = mockk<WriterRepository>()
    private val writerService = WriterService(writerRepository)

    @Test
    fun `이메일이 중복되면 회원 가입이 불가능하다`() {
        // given
        val memberAddDto = MemberAddDto(
            nickname = "nickname",
            password = "password",
            email = "test@test.com",
        )

        // when
        every { writerRepository.existsByEmail(any()) } returns true

        // then
        assertThatThrownBy {
            writerService.addMember(memberAddDto)
        }.isInstanceOf(AlreadyMemberException::class.java)

        verify {writerRepository.save(any()) wasNot Called }
    }

    @Test
    fun `닉네임이 중복되면 회원 가입이 불가능하다`() {
        // given
        val memberAddDto = MemberAddDto(
            nickname = "nickname",
            password = "password",
            email = "test@test.com",
        )

        // when
        every { writerRepository.existsByEmail(any()) } returns false
        every { writerRepository.existsByNickname(any()) } returns true

        // then
        assertThatThrownBy {
            writerService.addMember(memberAddDto)
        }.isInstanceOf(DuplicateNicknameException::class.java)

        verify {writerRepository.save(any()) wasNot Called }
    }
}