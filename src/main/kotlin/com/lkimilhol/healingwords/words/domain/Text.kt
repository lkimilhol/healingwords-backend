package com.lkimilhol.healingwords.words.domain

import com.lkimilhol.healingwords.exception.TextLengthExceedException
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Text {
    @Column(name = "text", nullable = false)
    private var content: String = ""

    companion object {
        const val MAX_LENGTH = 255

        private fun checkLength(content: String) {
            if (content.length > MAX_LENGTH) {
                throw TextLengthExceedException()
            }
        }
    }
}