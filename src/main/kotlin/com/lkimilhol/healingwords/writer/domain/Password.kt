package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.exception.PasswordLengthExceedException
import javax.persistence.Column
import javax.persistence.Embeddable

private const val MAX_LENGTH = 15

@Embeddable
class Password private constructor(
    @Column(name = "password", length = MAX_LENGTH, nullable = false)
    private var contents: String
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