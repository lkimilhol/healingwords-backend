package com.lkimilhol.healingwords.words.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.healingwords.exception.TextLengthExceedException;

class TextTest {

    @DisplayName("최대 길이 테스트")
    @Test
    void maxLength() {
        // given
        int index = 0;
        StringBuilder content = new StringBuilder();

        // when
        while (index++ < Text.MAX_LENGTH + 1) {
            content.append("t");
        }

        // then
        assertThatThrownBy(() -> new Text(content.toString()))
                .isInstanceOf(TextLengthExceedException.class);
    }
}