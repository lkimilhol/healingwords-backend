package com.lkimilhol.healingwords.words.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

import words.domain.Text;
import words.domain.Writer;

@Entity
@NoArgsConstructor
public class Words {

    @Id
    private Long id;

    @Embedded
    private Text text;

    @Embedded
    private Writer writer;

    // TODO 비밀번호 작성

    // TODO 작성일시

    // TODO 수정일시
}
