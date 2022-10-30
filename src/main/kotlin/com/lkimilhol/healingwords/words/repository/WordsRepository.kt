package com.lkimilhol.healingwords.words.repository

import com.lkimilhol.healingwords.words.domain.Words
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WordsRepository : JpaRepository<Words, Long> {
}