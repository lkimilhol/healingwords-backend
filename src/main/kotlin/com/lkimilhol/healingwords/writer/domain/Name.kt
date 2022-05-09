package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.writer.exception.NameLengthExceedException
import javax.persistence.Column
import javax.persistence.Embedded

private const val MAX_LENGTH = 10

class Name private constructor(
    @Embedded
    @Column(name = "name", nullable = false, length = MAX_LENGTH)
    private val contents: String

) {
    fun content(): String {
        return contents
    }

    companion object {
        fun create(contents: String): Name {
            validate(contents)
            return Name(contents)
        }

        private fun validate(contents: String) {
            if (contents.length > MAX_LENGTH) {
                throw NameLengthExceedException()
            }
        }
    }
}