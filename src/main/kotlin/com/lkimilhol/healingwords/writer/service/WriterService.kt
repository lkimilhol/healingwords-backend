package com.lkimilhol.healingwords.writer.service

import com.lkimilhol.healingwords.writer.domain.*
import com.lkimilhol.healingwords.writer.dto.MemberAddDto
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WriterService(
    private val writerRepository: WriterRepository
) {

    fun addMember(memberAddDto: MemberAddDto) {
        writerRepository.save(
            Writer.create(
                Nickname.create(memberAddDto.nickname),
                Password.create(memberAddDto.password),
                Email.create(memberAddDto.email),
                WriterAuth.MEMBER
            )
        )
    }
}