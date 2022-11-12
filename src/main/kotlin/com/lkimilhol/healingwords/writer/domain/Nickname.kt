package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.writer.exception.NicknameLengthExceedException
import javax.persistence.Column
import javax.persistence.Embeddable

private const val MAX_LENGTH = 10

@Embeddable
class Nickname private constructor(
    @Column(name = "nickname", length = MAX_LENGTH, nullable = false)
    private var contents: String

) {
    fun content(): String {
        return contents
    }

    companion object {
        fun create(contents: String): Nickname {
            validate(contents)
            return Nickname(contents)
        }

        private fun validate(contents: String) {
            if (contents.length > MAX_LENGTH) {
                throw NicknameLengthExceedException()
            }
        }
    }
}