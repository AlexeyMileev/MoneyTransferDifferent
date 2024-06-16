package ru.netology

fun main() {
    calculateComission(card = "Mastercard", 0, 150_000)
}

fun calculateComission(card: String = "Мир", previosTransfer: Int = 0, thisTransfer: Int ) {

    val limitMonthMastercadr = 75_000
    val minComissionVisa = 35.0
    val limitMonth = 600_000
    val limitDay = 150_000
    var transferComission: Double

    if(card == "Mastercard") {
        if(previosTransfer + thisTransfer <= limitMonth) {
            if(previosTransfer + thisTransfer <= limitDay) {
                if(previosTransfer + thisTransfer > limitMonthMastercadr) {
                    transferComission = (thisTransfer - limitMonthMastercadr) * userCardToComission(card) + 20
                } else {
                    transferComission = 0.0
                }
                println("Сумма перевода: $thisTransfer руб, комиссия: $transferComission руб. ")
            } else {
                println("Превышен суточный лимит")
            }
        } else {
            println("Превышен месячный лимит")
        }

    }

    if(card == "Visa") {
        if(previosTransfer + thisTransfer <= limitMonth) {
            if(previosTransfer + thisTransfer <= limitDay) {
                transferComission = thisTransfer * userCardToComission(card)
                if(transferComission <= minComissionVisa) {
                    transferComission = minComissionVisa
                } else {
                }
                println("Сумма перевода: $thisTransfer руб, комиссия: $transferComission руб. ")
            } else {
                println("Превышен суточный лимит")
            }
        } else {
            println("Превышен месячный лимит")
        }

    }

    if(card == "Мир") {
        if(previosTransfer + thisTransfer <= limitMonth) {
            if(previosTransfer + thisTransfer <= limitDay) {
                transferComission = thisTransfer * userCardToComission(card)
                println("Сумма перевода: $thisTransfer руб, комиссия: $transferComission руб. ")
            } else {
                println("Превышен суточный лимит")
            }
        } else {
            println("Превышен месячный лимит")
        }

    }

}

fun userCardToComission(card: String) = when(card) {
    "Mastercard" -> 0.006
    "Visa" -> 0.0075
    else -> 0.0
}