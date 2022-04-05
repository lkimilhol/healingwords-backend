package com.lkimilhol.healingwords.words.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Words {

    @Id
    private Long id;


}
