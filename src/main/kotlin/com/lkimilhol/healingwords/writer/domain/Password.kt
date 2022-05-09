package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.exception.PasswordLengthExceedException
import javax.persistence.Column

private const val MAX_LENGTH = 15

class Password private constructor(
    @Column(name = "password", length = MAX_LENGTH)
    private val contents: String
) {

    fun contents(): String {
        return contents
    }

    companion object {
        fun create(contents: String): Password {
            checkLength(contents)
            return Password(contents)
        }

        private fun checkLength(contents: String) {
            if (contents.length > MAX_LENGTH) {
                throw PasswordLengthExceedException()
            }
        }
    }
}