package com.example.bankaccountprogram

fun main(){
    println("Welcome to bank main")

    val kuntalsAccount=BankAccount("Kuntal", 400.25)
    kuntalsAccount.diposit(700.00)
    kuntalsAccount.withdrow(120.00)
    kuntalsAccount.diposit(300.00)
    kuntalsAccount.diposit(112.25)
    kuntalsAccount.withdrow(2000.30)
    kuntalsAccount.displayTransactionHistory()
    println("${kuntalsAccount.accountHolder}'s is having the balance $  ${kuntalsAccount.balance}")
}