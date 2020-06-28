package ru.skillfactory.bankservice

import com.fasterxml.jackson.databind.ObjectMapper
import org.elasticsearch.index.Index
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates
import org.springframework.data.elasticsearch.core.query.IndexQuery
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import ru.skillfactory.bankservice.OperationType.*
import java.util.*

@SpringBootApplication
@EnableScheduling
class BankServiceApplication(
        val elasticsearchOperations: ElasticsearchOperations
) {
    val objectMapper = ObjectMapper()
    val account = Account(10_000)

    @Scheduled(fixedDelay = 1000)
    fun doOperation() {
        when (makeChoice()) {
            1 -> {
                account.balance
                sendOperation(BALANCE,account.balance)
            }
//            2 -> {
//                val sum = (0..10_000).random()
//                account.addMoney(sum)
//                sendOperation(ADD,sum)
//            }
            3 -> {
                val sum = (0..10_000).random()
                account.takeMoney(sum)
                sendOperation(TAKE,sum)
            }
        }
        println("balance: ${account.balance}")
    }

    @Scheduled(fixedDelay = 1000)
    fun sendStatistic() {
        val indexQuery = IndexQueryBuilder()
                .withSource(
                        objectMapper.writeValueAsString(
                                Operation(date = Date(), operationType = BALANCE, sum = account.balance)
                        ))
                .build()
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of("balance"))
    }

    fun sendOperation(operationType: OperationType,sum:Int) {
        val string = objectMapper.writeValueAsString(
                Operation(date = Date(), operationType = operationType, sum = sum)
        )
        println(string)
        val indexQuery = IndexQueryBuilder()
                .withSource(
                        string)
                .build()
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of("operation"))
    }
}


private fun makeChoice() = (1..4).random()

fun main(args: Array<String>) {
    runApplication<BankServiceApplication>(*args)
}
