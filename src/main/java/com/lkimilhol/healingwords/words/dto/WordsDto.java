package com.lkimilhol.healingwords.words.dto;

import lombok.Getter;

@Getter
public class WordsDto {
    public WordsDto(String author, String content) {
        this.author = author;
        this.content = content;
    }

    private final String author;
    private final String content;
}
