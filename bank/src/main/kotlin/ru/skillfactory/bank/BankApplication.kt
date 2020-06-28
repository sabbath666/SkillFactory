package ru.skillfactory.bank

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    println("Добро пожаловать в банк!")
    val account = Account(10_000)
    showMenu()
    var choice = 0
    while (choice != 5) {
        choice = makeChoice()
        when (choice) {
            1 -> getBalance(account)
            2 -> withdrawMoney(account)
            3 -> addMoney(account)
            4 -> showMenu()
            5 -> println("Пока!")
        }
    }
}

private fun addMoney(account: Account) {
    println("Сколько положить?")
    val cash = readSum()
    account.addMoney(cash)
    println("Вы внесли $cash")
}

private fun withdrawMoney(account: Account) {
    println("Сколько снять?")
    val cash = readSum()
    if (account.balance >= cash) {
        println("Держи: $cash")
        account.takeMoney(cash)
    } else {
        println("Столько нет!")
    }
}

private fun getBalance(account: Account) {
    println("На счету осталось: ${account.balance}")
}

private fun makeChoice() = scanner.nextInt()
private fun readSum() = scanner.nextInt()

private fun showMenu() {
    println("-------------------------------------------------------")
    println("1 - посмотреть баланс")
    println("2 - снять")
    println("3 - положить")
    println("4 - меню")
    println("5 - выход")
    println("-------------------------------------------------------")
}

