//package com.lkimilhol.healingwords.words.service
//
//import com.lkimilhol.healingwords.exception.NotFoundWordsException
//import com.lkimilhol.healingwords.exception.NotMatchPasswordException
//import com.lkimilhol.healingwords.words.domain.Text
//import com.lkimilhol.healingwords.words.domain.Words
//import com.lkimilhol.healingwords.words.dto.CreateWordsNonMemberDto
//import com.lkimilhol.healingwords.words.dto.ModifyWordsNonMemberDto
//import com.lkimilhol.healingwords.words.repository.WordsRepository
//import com.lkimilhol.healingwords.writer.domain.Email
//import com.lkimilhol.healingwords.writer.domain.Name
//import com.lkimilhol.healingwords.writer.domain.Password
//import com.lkimilhol.healingwords.writer.domain.Writer
//import org.springframework.stereotype.Service
//import org.springframework.transaction.annotation.Transactional
//
//@Service
//@Transactional
//class WordsService(
//    private val wordsRepository: WordsRepository
//) {
//
//    // 비회원 글 작성
//    fun writeWithNonMember(wordsDto: CreateWordsNonMemberDto) {
//        val words = Words.create(
//            Text.create(wordsDto.content),
//            Writer.create(
//                Name.create(wordsDto.author),
//                Password.create(wordsDto.password),
//                Email.create(wordsDto.email)
//            )
//        )
//
//        wordsRepository.save(words)
//    }
//
//    // 비회원 글 수정
//    fun modifyWithNonMember(wordsDto: ModifyWordsNonMemberDto) {
//        val words = wordsRepository.findById(wordsDto.id)
//            .orElseThrow {NotFoundWordsException()}
//
//        if (words.writer.password().equals(Password.create(wordsDto.password))) {
//            throw NotMatchPasswordException()
//        }
//
//        words.text = Text.create(wordsDto.content)
//
//        wordsRepository.save(words)
//    }
//}