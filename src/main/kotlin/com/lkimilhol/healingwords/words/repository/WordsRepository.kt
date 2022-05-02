package com.lkimilhol.healingwords.words.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.lkimilhol.healingwords.words.domain.Words

@Repository
interface WordsRepository : JpaRepository<Words, Long> {
}