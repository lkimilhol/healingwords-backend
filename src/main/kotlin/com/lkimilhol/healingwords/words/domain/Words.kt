package com.lkimilhol.healingwords.words.domain

import com.lkimilhol.healingwords.writer.domain.Writer
import javax.persistence.*

@Entity
@Table(name = "words")
class Words(
    @ManyToOne
    private var writer: Writer?,

    @Embedded
    private var text: Text?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
    // TODO 작성일시
    // TODO 수정일시
}