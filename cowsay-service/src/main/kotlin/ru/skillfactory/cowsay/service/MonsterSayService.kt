package ru.skillfactory.cowsay.service

import com.github.ricksbrown.cowsay.plugin.CowExecutor
import org.springframework.stereotype.Service
import ru.skillfactory.cowsay.service.SayService

@Service
class MonsterSayService(
        val cowExecutor: CowExecutor,
        val quoteService: QuoteService,
        val monsters: List<String>
) : SayService {
    override fun say(message: String): String {
        cowExecutor.setMessage(message)
        cowExecutor.setCowfile(monsters.random())
        return cowExecutor.execute()
    }

    override fun sayQuote(): String {
        val queue = quoteService.getQuote()
        cowExecutor.setMessage(queue)
        cowExecutor.setCowfile(monsters.random())
        return cowExecutor.execute()
    }
}

