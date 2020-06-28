package ru.skillfactory.bankservice


data class Account(
        var balance: Int
) {
    fun takeMoney(sum: Int) {
        balance -= sum
    }

    fun addMoney(sum: Int) {
        balance += sum
    }

}