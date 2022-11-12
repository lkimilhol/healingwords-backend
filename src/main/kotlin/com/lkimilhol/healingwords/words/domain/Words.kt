package com.lkimilhol.healingwords.words.domain

import javax.persistence.*

@Entity
@Table(name = "words")
class Words {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Column
    private var text: Text? = null

    // TODO 작성일시

    // TODO 수정일시

    // TODO 작성자 (admin, 추천자)

//    @Embedded
//    var text: Text? = null

//    @Embedded
//    var writer: Writer? = null
}