package com.lkimilhol.healingwords.words.domain

import javax.persistence.*

@Entity
@Table(name = "forbidden_words")
class ForbiddenWords(
    @Column(name = "content", nullable = false)
    val content: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}