package com.lkimilhol.healingwords.writer.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Writer(
    @Embedded
    private var nickname: Nickname?,

    @Embedded
    private var password: Password?,

    @Embedded
    private var email: Email?,

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private var writerAuth: WriterAuth,

    @Column(columnDefinition = "tinyint(1) default 1")
    private var withdraw: Boolean = false,

    @Column(nullable = false)
    private val createDateTime: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    private val updateDateTime: LocalDateTime = LocalDateTime.now(),

    @Column
    private var withdrawDateTime: LocalDateTime? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    fun nickname(): Nickname? {
        return nickname
    }

    fun password(): Password? {
        return password
    }

    fun email(): Email? {
        return email
    }

    fun auth(): WriterAuth {
        return writerAuth
    }

    companion object {
        fun create(nickname: Nickname, password: Password, email: Email, writerAuth: WriterAuth): Writer {
            return Writer(nickname, password, email, writerAuth)
        }
    }
}