package com.lkimilhol.healingwords.words.service

import com.lkimilhol.healingwords.words.domain.Text
import com.lkimilhol.healingwords.words.domain.Words
import com.lkimilhol.healingwords.words.dto.WriteWordsDto
import com.lkimilhol.healingwords.words.repository.WordsRepository
import com.lkimilhol.healingwords.writer.exception.NotFoundWriterException
import com.lkimilhol.healingwords.writer.repository.WriterRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class WordsService(
    private val writerRepository: WriterRepository,
    private val wordsRepository: WordsRepository
) {

    // 비회원 글 작성
    fun write(wordsDto: WriteWordsDto) {
        val writer = writerRepository.findById(wordsDto.writerId)

        if (writer.isEmpty) {
            throw NotFoundWriterException()
        }

        val words = Words(
            writer.get(),
            Text.create(wordsDto.content)
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