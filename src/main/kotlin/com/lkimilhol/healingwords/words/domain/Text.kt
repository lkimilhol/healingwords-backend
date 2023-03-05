package com.lkimilhol.healingwords.words.domain

import com.lkimilhol.healingwords.exception.TextLengthExceedException
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Text(
    @Column(name = "text", nullable = false)
    var content: String
) {

    fun hasForbidden(it: String): Boolean {
        return content.contains(it)
    }

    companion object {
        const val MAX_LENGTH = 255

        fun create(content: String): Text {
            checkLength(content)
            return Text(content)
        }

        private fun checkLength(content: String) {
            if (content.length > MAX_LENGTH) {
                throw TextLengthExceedException()
            }
        }
    }
}