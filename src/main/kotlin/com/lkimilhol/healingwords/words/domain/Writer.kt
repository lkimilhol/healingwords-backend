package com.lkimilhol.healingwords.words.domain

import com.lkimilhol.healingwords.exception.WriterLengthExceedException
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Writer private constructor(
    @Column(name = "writer", nullable = false)
    private val name: String
) {

    fun name(): String {
        return name
    }

    companion object {
        const val MAX_LENGTH = 15

        fun create(name: String): Writer {
            checkLength(name)
            return Writer(name)
        }

        private fun checkLength(name: String) {
            if (name.length > MAX_LENGTH) {
                throw WriterLengthExceedException()
            }
        }
    }
}