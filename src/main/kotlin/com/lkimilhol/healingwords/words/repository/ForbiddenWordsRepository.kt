package com.lkimilhol.healingwords.words.repository

import com.lkimilhol.healingwords.words.domain.ForbiddenWords
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ForbiddenWordsRepository : JpaRepository<ForbiddenWords, Long?> {
}