package com.lkimilhol.healingwords.writer.service

import com.lkimilhol.healingwords.writer.domain.*
import com.lkimilhol.healingwords.writer.dto.MemberAddDto
import com.lkimilhol.healingwords.writer.exception.AlreadyMemberException
import com.lkimilhol.healingwords.writer.exception.DuplicateNicknameException
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WriterService(
    private val writerRepository: WriterRepository
) {

    fun addMember(memberAddDto: MemberAddDto) {
        val nickname = Nickname.create(memberAddDto.nickname)
        val email = Email.create(memberAddDto.email)

        if (writerRepository.existsByEmail(email)) {
            throw AlreadyMemberException()
        }

        if (writerRepository.existsByNickname(nickname)) {
            throw DuplicateNicknameException()
        }

        writerRepository.save(
            Writer.create(
                nickname,
                Password.create(memberAddDto.password),
                email,
                WriterAuth.MEMBER
            )
        )
    }
}