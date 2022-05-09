package com.lkimilhol.healingwords.writer.domain

import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
class Writer private constructor(
    @Embedded
    private val name: Name,

    @Embedded
    private val password: Password
) {

    fun name(): String {
        return name.content()
    }

    companion object {
        fun create(name: Name, password: Password): Writer {
            return Writer(name, password)
        }
    }
}