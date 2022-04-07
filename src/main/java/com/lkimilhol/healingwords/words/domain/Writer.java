package com.lkimilhol.healingwords.words.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

import com.lkimilhol.healingwords.exception.WriterLengthExceedException;

@Embeddable
@NoArgsConstructor
public class Writer {
    public static final int MAX_LENGTH = 15;

    @Column(name = "writer", nullable = false)
    private String name;

    public Writer(String name) {
        checkLength(name);
        this.name = name;
    }

    private void checkLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new WriterLengthExceedException();
        }
    }
}
