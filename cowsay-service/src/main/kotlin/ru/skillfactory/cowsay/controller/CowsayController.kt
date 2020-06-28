package ru.skillfactory.cowsay.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.skillfactory.cowsay.service.GreenElephantQuoteService
import ru.skillfactory.cowsay.service.SayService

@RestController
class CowsayController(
        val sayService: SayService,
        val quoteService: GreenElephantQuoteService
) {
    @GetMapping("/say")
    fun say(@RequestParam message: String? = "") = when {
        message.isNullOrEmpty() -> {
            val queue = quoteService.getQuote()
            sayService.say(queue)
        }
        else -> {
            sayService.say(message)
        }
    }
}
