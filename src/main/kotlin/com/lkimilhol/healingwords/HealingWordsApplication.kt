package com.lkimilhol.healingwords

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class HealingWordsApplication

fun main(args: Array<String>) {
    runApplication<HealingWordsApplication>(*args)
}
