package com.lkimilhol.healingwords.writer.service

import com.lkimilhol.healingwords.writer.domain.Email
import com.lkimilhol.healingwords.writer.domain.Name
import com.lkimilhol.healingwords.writer.domain.Password
import com.lkimilhol.healingwords.writer.domain.Writer
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyLong
import java.util.*

internal class WriterServiceTest {
    private val writerRepository = mockk<WriterRepository>()
    private val writerService = WriterService(writerRepository)

    @Test
    fun `작가 정보`() {
        // given
        val writer = Writer.create(
            Name.create("name"),
            Password.create("password"),
            Email.create("test@healingwords.com"),
        )

        // when
        every { writerRepository.findById(anyLong()) } returns Optional.of(writer)
        val writerInfo = writerService.get(anyLong())

        // then
        assertThat(writerInfo.name).isEqualTo("name")
        assertThat(writerInfo.email).isEqualTo("test@healingwords.com")
    }
}