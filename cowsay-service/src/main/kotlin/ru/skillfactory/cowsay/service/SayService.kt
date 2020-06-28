package ru.skillfactory.cowsay.service

interface SayService {
    fun say(message: String = "Hey"): String
    fun sayQuote(): String
}