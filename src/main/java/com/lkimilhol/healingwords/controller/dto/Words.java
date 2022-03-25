package com.lkimilhol.healingwords.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Words {
    private final String author;
    private final String content;
}
