package com.lkimilhol.healingwords.writer.domain

import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
class Writer private constructor(
    @Embedded
    private var name: Name,

    @Embedded
    private var password: Password,

    @Embedded
    private var email: Email
) {

    fun name(): String {
        return name.content()
    }

    fun password(): String {
        return password.contents()
    }

    fun email(): String {
        return email.contents()
    }

    companion object {
        fun create(name: Name, password: Password, email: Email): Writer {
            return Writer(name, password, email)
        }
    }
}