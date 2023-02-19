package com.lkimilhol.healingwords

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class HealingWordsApplication

fun main(args: Array<String>) {
    runApplication<HealingWordsApplication>(*args)
}