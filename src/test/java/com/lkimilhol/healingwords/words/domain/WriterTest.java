package com.lkimilhol.healingwords.words.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.healingwords.exception.WriterLengthExceedException;

class WriterTest {

    @DisplayName("작성자 생성 실패")
    @Test
    void createFailed() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Writer("lkimilhollkimilhol"))
                .isInstanceOf(WriterLengthExceedException.class);
    }
}