package com.lkimilhol.healingwords.words.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Words {

    @Id
    private Long id;

    // TODO 포장 클래스 생성
    private String content;

    // TODO 글쓴이 작성

    // TODO 비밀번호 작성

    // TODO 작성일시

    // TODO 수정일시
}
