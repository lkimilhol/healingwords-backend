package com.lkimilhol.healingwords.writer.repository

import com.lkimilhol.healingwords.writer.domain.Email
import com.lkimilhol.healingwords.writer.domain.Nickname
import com.lkimilhol.healingwords.writer.domain.Writer
import org.springframework.data.jpa.repository.JpaRepository

interface WriterRepository : JpaRepository<Writer, Long> {
    fun existsByNickname(nickname: Nickname): Boolean
    fun existsByEmail(email: Email): Boolean
    fun findWriterByEmail(email: Email): Writer?
}