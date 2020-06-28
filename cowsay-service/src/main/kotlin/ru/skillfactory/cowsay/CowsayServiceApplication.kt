package ru.skillfactory.cowsay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CowsayServiceApplication

fun main(args: Array<String>) {
    runApplication<CowsayServiceApplication>(*args)
}
