package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.writer.exception.EmailLengthExceedException
import com.lkimilhol.healingwords.writer.exception.InvalidEmailFormException
import java.util.regex.Pattern
import javax.persistence.Column

private const val MAX_LENGTH = 15
private const val EMAIL_REGEX = "^(.+)@(.+)\$"

class Email private constructor(
    @Column(name = "password", length = MAX_LENGTH, nullable = false)
    private val contents: String
) {
    fun contents(): String {
        return contents
    }

    companion object {
        fun create(contents: String): Email {
            validate(contents)
            return Email(contents)
        }

        private fun validate(content: String) {
            if (!Pattern.matches(EMAIL_REGEX, content)) {
                throw InvalidEmailFormException()
            }

            if (content.split("@")[0].length > MAX_LENGTH) {
                throw EmailLengthExceedException()
            }
        }
    }
}