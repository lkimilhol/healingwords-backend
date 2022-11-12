package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.writer.exception.NicknameLengthExceedException
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded

private const val MAX_LENGTH = 10

@Embeddable
class Nickname private constructor(
    @Embedded
    @Column(name = "nickname", nullable = false, length = MAX_LENGTH)
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