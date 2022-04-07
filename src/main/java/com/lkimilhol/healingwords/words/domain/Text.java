package com.lkimilhol.healingwords.words.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

import com.lkimilhol.healingwords.exception.TextLengthExceedException;

@Embeddable
@NoArgsConstructor
public class Text {
    public static final int MAX_LENGTH = 255;

    @Column(name = "text", nullable = false)
    private String content;

    public Text(String content) {
        checkLength(content);
        this.content = content;
    }

    private void checkLength(String content) {
        if (content.length() > MAX_LENGTH) {
            throw new TextLengthExceedException();
        }
    }
}
