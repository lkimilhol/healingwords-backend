package com.lkimilhol.healingwords.words.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

import com.lkimilhol.healingwords.exception.TextLengthExceedException;

@Embeddable
@NoArgsConstructor
public class Text {
    public static int MAX_LENGTH = 255;

    @Column(name = "text", nullable = false)
    private String content;

    public Text(String content) {
        if (content.length() > MAX_LENGTH) {
            throw new TextLengthExceedException();
        }

        this.content = content;
    }
}
