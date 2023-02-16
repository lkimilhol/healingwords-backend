package com.lkimilhol.healingwords.writer.service

import com.lkimilhol.healingwords.writer.domain.*
import com.lkimilhol.healingwords.writer.dto.request.WriterAddRequest
import com.lkimilhol.healingwords.writer.dto.request.WriterLoginRequest
import com.lkimilhol.healingwords.writer.exception.AlreadyMemberException
import com.lkimilhol.healingwords.writer.exception.DuplicateNicknameException
import com.lkimilhol.healingwords.writer.exception.InvalidPasswordException
import com.lkimilhol.healingwords.writer.exception.NotFoundWriterException
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import com.lkimilhol.healingwords.writer.token.JwtTokenService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WriterService(
    private val writerRepository: WriterRepository,
    private val jwtTokenService: JwtTokenService
) {

    fun addMember(writerAddRequest: WriterAddRequest) {
        val nickname = Nickname.create(writerAddRequest.nickname)
        val email = Email.create(writerAddRequest.email)

        if (writerRepository.existsByEmail(email)) {
            throw AlreadyMemberException()
        }

        if (writerRepository.existsByNickname(nickname)) {
            throw DuplicateNicknameException()
        }

        writerRepository.save(
            Writer.create(
                nickname,
                Password.create(writerAddRequest.password),
                email,
                WriterAuth.MEMBER
            )
        )
    }

    fun login(writerLoginRequest: WriterLoginRequest) {
        val writer = writerRepository.findWriterByEmail(Email.create(writerLoginRequest.email))
            ?: throw NotFoundWriterException()

        if (Password.create(writerLoginRequest.password) != writer.password()) {
            throw InvalidPasswordException()
        }

        jwtTokenService.generateToken(writer.email()!!)
    }
}