package com.lkimilhol.healingwords.writer.repository

import com.lkimilhol.healingwords.writer.domain.Writer
import org.springframework.data.jpa.repository.JpaRepository

interface WriterRepository : JpaRepository<Writer, Long> {
}