package com.lkimilhol.healingwords.words.domain

import com.lkimilhol.healingwords.writer.domain.Writer
import javax.persistence.*

@Entity
class Words private constructor(
    @Embedded
    var text: Text,

    @Embedded
    var writer: Writer
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    // TODO 비밀번호 작성

    // TODO 작성일시

    // TODO 수정일시

    companion object {
        fun create(text: Text, writer: Writer) : Words {
            return Words(text, writer)
        }
    }
}