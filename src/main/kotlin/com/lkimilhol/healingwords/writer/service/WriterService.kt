package com.lkimilhol.healingwords.writer.service

import com.lkimilhol.healingwords.writer.domain.Email
import com.lkimilhol.healingwords.writer.domain.Name
import com.lkimilhol.healingwords.writer.domain.Password
import com.lkimilhol.healingwords.writer.domain.Writer
import com.lkimilhol.healingwords.writer.dto.WriterDto
import com.lkimilhol.healingwords.writer.dto.WriterInfoDto
import com.lkimilhol.healingwords.writer.exception.NotFoundWriterException
import com.lkimilhol.healingwords.writer.exception.WriterNameDuplicateException
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import org.springframework.stereotype.Service

@Service
class WriterService(
    private val writerRepository: WriterRepository
) {

    fun register(writerDto: WriterDto): WriterDto {
        val existingWriter = writerRepository.findWriterByName(Name.create(writerDto.name))

        if (existingWriter.isPresent) {
            throw WriterNameDuplicateException()
        }

        val writer = writerRepository.save(
            Writer.create(
                Name.create(writerDto.name),
                Password.create(writerDto.password),
                Email.create(writerDto.email)
            )
        )

        return WriterDto(
            writer.name(),
            writer.password(),
            writer.email()
        )
    }

    fun get(id: Long): WriterInfoDto {
        val writer = writerRepository.findById(id).orElseThrow { NotFoundWriterException() }
        return WriterInfoDto(
            writer.name(),
            writer.email()
        )
    }
}