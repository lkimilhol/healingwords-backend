package com.lkimilhol.healingwords.writer.domain

import javax.persistence.*

@Entity
class Writer(
    @Embedded
    private var name: Name?,

    @Embedded
    private var password: Password?,

    @Embedded
    private var email: Email?,

    @Enumerated(value = EnumType.STRING)
    private var auth: Auth
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    companion object {
        fun create(name: Name, password: Password, email: Email, auth: Auth): Writer {
            return Writer(name, password, email, auth)
        }
    }
}