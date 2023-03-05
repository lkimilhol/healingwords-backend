package com.lkimilhol.healingwords.words.service

import com.lkimilhol.healingwords.exception.TextHasForbiddenWordException
import com.lkimilhol.healingwords.words.domain.Text
import com.lkimilhol.healingwords.words.domain.Words
import com.lkimilhol.healingwords.words.dto.WriteWordsDto
import com.lkimilhol.healingwords.words.repository.ForbiddenWordsRepository
import com.lkimilhol.healingwords.words.repository.WordsRepository
import com.lkimilhol.healingwords.writer.exception.NotFoundWriterException
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WordsService(
    private val writerRepository: WriterRepository,
    private val wordsRepository: WordsRepository,
    private val forbiddenWordsRepository: ForbiddenWordsRepository
) {

    fun write(wordsDto: WriteWordsDto) {
        val writer = writerRepository.findById(wordsDto.writerId)

        if (writer.isEmpty) {
            throw NotFoundWriterException()
        }

        val text = Text.create(wordsDto.content)

        val forbiddenWords = forbiddenWordsRepository.findAll()

        forbiddenWords.forEach {
            if (text.hasForbidden(it.content)) {
                throw TextHasForbiddenWordException()
            }
        }

        val words = Words(
            writer.get(),
            text
        )

        wordsRepository.save(words)
    }

//    // 비회원 글 수정
//    fun modifyWithNonMember(wordsDto: ModifyWordsNonMemberDto) {
//        val words = wordsRepository.findById(wordsDto.id)
//            .orElseThrow { NotFoundWordsException() }
//
//        if (words.writer.password().equals(Password.create(wordsDto.password))) {
//            throw NotMatchPasswordException()
//        }
//
//        words.text = Text.create(wordsDto.content)
//
//        wordsRepository.save(words)
//    }
}