package com.example.myapplication

fun initGame(gameBoard: String) {
    println("---------")
    println("| ${gameBoard[0]} ${gameBoard[1]} ${gameBoard[2]} |")
    println("| ${gameBoard[3]} ${gameBoard[4]} ${gameBoard[5]} |")
    println("| ${gameBoard[6]} ${gameBoard[7]} ${gameBoard[8]} |")
    println("---------")
}

fun main() {

    val turns = readln()
    initGame(turns)
    var test = ""

    do {
        var check = false

        val switch = readln()

        if (switch[0] in 'a'..'z') {
            println("You should enter numbers!")
            check = true
        }

        if (switch[0] > '3') {
            println("Coordinates should be from 1 to 3!")
            check = true
        }

        if (switch[0] == '1') {
            val see1 = switch[2].toString().toInt() - switch[0].toString().toInt()
            if (turns[see1] != '_') {
                println("This cell is occupied! Choose another one!")
                check = true
            }
        }

        if (switch[0] == '2') {
            val see2 = switch[2].toString().toInt() + switch[0].toString().toInt()
            if (turns[see2] != '_') {
                println("This cell is occupied! Choose another one!")
                check = true
            }
        }

        if (switch[0] == '3') {
            val see3 = switch[0].toString().toInt() * 2 + switch[2].toString().toInt() - 1
            if (turns[see3] != '_') {
                println("This cell is occupied! Choose another one!")
                check = true
            }
        }

        if (!check) {
            test = switch.substring(0,3)
        }

    } while (check)

    if (test[0] == '1') {
        val idx = test[2].toString().toInt() - test[0].toString().toInt()

        val fin1 = turns.substring(0, idx)
        val fin2 = turns.substring(idx + 1)

        val done = fin1 + 'X' + fin2
        initGame(done)
    }

    else if (test[0] == '2') {
        val idx = test[2].toString().toInt() + test[0].toString().toInt()

        val fin1 = turns.substring(0, idx)
        val fin2 = turns.substring(idx + 1)

        val done = fin1 + 'X' + fin2
        initGame(done)
    }

    else {
        val idx = test[0].toString().toInt() * 2 + test[2].toString().toInt() - 1

        val fin1 = turns.substring(0, idx)
        val fin2 = turns.substring(idx + 1)

        val done = fin1 + 'X' + fin2
        initGame(done)
    }
}