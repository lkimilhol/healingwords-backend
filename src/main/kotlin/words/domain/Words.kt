package words.domain

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Words(
    @Embedded
    val text: Text,

    @Embedded
    val writer: Writer
) {

    @Id
    private val id: Long? = null

    // TODO 비밀번호 작성

    // TODO 작성일시

    // TODO 수정일시

    companion object {
        fun create(text: Text, writer: Writer) : Words {
            return Words(text, writer)
        }
    }
}