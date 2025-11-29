package com.example.rockpaperscissors

fun main(){
    var computerChoice=""
    var playerChoice=""

    println("Rock, Paper or Scissors enter the Player's choice!")
    playerChoice= readln()

    val randomNumber=(1..3).random()
    /*if(randomNumber==1){
        computerChoice="Rock"
    }
    else if(randomNumber==2){
       computerChoice="Paper"
    }
    else{
        computerChoice="Scissors"
    }*/
    when(randomNumber){
        1-> computerChoice="Rock"
        2-> computerChoice="Paper"
        3-> computerChoice="Scissors"
    }
    println(computerChoice)

    val winner=when{
        playerChoice==computerChoice->"Tie.."
        playerChoice=="Rock" && computerChoice=="Scissors"->"Player"
        playerChoice=="Paper" && computerChoice=="Rock"->"Player"
        playerChoice=="Scissors" && computerChoice=="Paper"->"Player"
        else -> "Computer"
    }
    if(winner=="Tie.."){
        println("It's a Tie! Try Again!")
    }
    else{
        println("The winner is : "+ winner)
    }
}