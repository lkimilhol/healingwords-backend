package com.lkimilhol.healingwords.words.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class WordsDto {
    private final String author;
    private final String content;
}
