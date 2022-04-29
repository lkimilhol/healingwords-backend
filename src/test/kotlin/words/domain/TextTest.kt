package words.domain

import exception.TextLengthExceedException
import io.kotlintest.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("글 작성 테스트")
internal class TextTest {

    @Test
    fun `작성 실패`() {
        // given
        var index = 0
        val content = StringBuilder()

        // when
        while (index++ < Text.MAX_LENGTH + 1) {
            content.append("t")
        }

        // then
        assertThatThrownBy { Text.create(content.toString()) }
            .isInstanceOf(TextLengthExceedException::class.java)
    }

    @Test
    fun `작성 성공`() {
        // given
        val content = "글작성"

        // when
        val text = Text.create(content)

        // then
        text.content() shouldBe content
    }
}