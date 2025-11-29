package com.example.bankaccountprogram

class BankAccount(val accountHolder:String, var balance:Double) {

    private var transactionHistory = mutableListOf<String>()

    fun diposit(amount:Double){
        balance +=amount
        transactionHistory.add("$accountHolder diposited $$amount")
    }
    fun withdrow(amount:Double){
        if(amount<=balance){
            balance -= amount
            transactionHistory.add("$accountHolder withdrew $$amount")
        }
        else{
            transactionHistory.add("Required amount is not available in the account")
        }
    }
    fun displayTransactionHistory(){
        println("Transaction history of $accountHolder")

        for(transaction in transactionHistory){
            println(transaction)
        }
    }
}

