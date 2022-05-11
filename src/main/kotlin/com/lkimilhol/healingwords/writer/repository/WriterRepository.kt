package com.lkimilhol.healingwords.writer.repository

import com.lkimilhol.healingwords.writer.domain.Name
import com.lkimilhol.healingwords.writer.domain.Writer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface WriterRepository: JpaRepository<Writer, Long> {
    fun findWriterByName(name: Name): Optional<Writer?>
}