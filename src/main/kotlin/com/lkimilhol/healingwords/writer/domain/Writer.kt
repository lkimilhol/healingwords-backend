package com.lkimilhol.healingwords.writer.domain

import com.lkimilhol.healingwords.exception.WriterLengthExceedException
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
class Writer private constructor(
    @Column(name = "writer", nullable = false)
    private val name: String,

   @Embedded
   private val password: Password
) {

    fun name(): String {
        return name
    }

    companion object {
        const val MAX_LENGTH = 15

        fun create(name: String, password: Password): Writer {
            checkLength(name)
            return Writer(name, password)
        }

        private fun checkLength(name: String) {
            if (name.length > MAX_LENGTH) {
                throw WriterLengthExceedException()
            }
        }
    }
}