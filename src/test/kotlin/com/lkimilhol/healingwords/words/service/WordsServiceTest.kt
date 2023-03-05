package com.lkimilhol.healingwords.words.service

import com.lkimilhol.healingwords.exception.TextHasForbiddenWordException
import com.lkimilhol.healingwords.words.domain.ForbiddenWords
import com.lkimilhol.healingwords.words.dto.WriteWordsDto
import com.lkimilhol.healingwords.words.repository.ForbiddenWordsRepository
import com.lkimilhol.healingwords.words.repository.WordsRepository
import com.lkimilhol.healingwords.writer.domain.*
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.util.*

internal class WordsServiceTest {
    private val writerRepository = mockk<WriterRepository>()
    private val wordsRepository = mockk<WordsRepository>()
    private val forbiddenWordsRepository = mockk<ForbiddenWordsRepository>()
    private val wordsService = WordsService(writerRepository, wordsRepository, forbiddenWordsRepository)

    @Test
    fun `금칙어가 있는 경우 글 작성이 되지 않아야 한다`() {
        val writeWordsDto = WriteWordsDto(1L, "금칙어")

        val writer = Writer(
            Nickname.create("닉네임"),
            Password.create("패스워드"),
            Email.create("email@email.com"),
            WriterAuth.MEMBER
        )

        every { writerRepository.findById(1L) } returns Optional.of(writer)
        every { forbiddenWordsRepository.findAll() } returns listOf(ForbiddenWords("금칙어"))

        assertThatThrownBy {
            wordsService.write(writeWordsDto)
        }.isExactlyInstanceOf(TextHasForbiddenWordException::class.java)

        verify(exactly = 0) { wordsRepository.save(any()) }
    }
}