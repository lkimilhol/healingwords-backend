package com.lkimilhol.healingwords.writer.domain

import javax.persistence.Column

class Password private constructor(
    @Column(name = "password", length = 15)
    private val contents : String
        ) {

    companion object {
        fun create(contents: String): Password {
            return Password(contents)
        }
    }
}