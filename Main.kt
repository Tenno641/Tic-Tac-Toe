fun initGame(gameBoard: String) {
    println("---------")
    println("| ${gameBoard[0]} ${gameBoard[1]} ${gameBoard[2]} |")
    println("| ${gameBoard[3]} ${gameBoard[4]} ${gameBoard[5]} |")
    println("| ${gameBoard[6]} ${gameBoard[7]} ${gameBoard[8]} |")
    println("---------")
}

fun main() {
    var board = "         "
    initGame(board)

    var test = ""

    for (turn in 0..8) {

        val player = if (turn % 2 == 0) 'X' else 'O'

        do {
            var check = false

            val switch = readln()

            if (switch[0] in 'a'..'z') {
                println("You should enter numbers!")
                check = true
                continue
            }

            if (switch[0] > '3' || switch[2] > '3') {
                println("Coordinates should be from 1 to 3!")
                check = true
                continue
            }

            if (switch[0] == '1') {
                val see1 = switch[2].toString().toInt() - switch[0].toString().toInt()
                if (board[see1] != ' ') {
                    println("This cell is occupied! Choose another one!")
                    check = true
                    continue
                }
            }

            if (switch[0] == '2') {
                val see2 = switch[2].toString().toInt() + switch[0].toString().toInt()
                if (board[see2] != ' ') {
                    println("This cell is occupied! Choose another one!")
                    check = true
                    continue
                }
            }

            if (switch[0] == '3') {
                val see3 = switch[0].toString().toInt() * 2 + switch[2].toString().toInt() - 1
                if (board[see3] != ' ') {
                    println("This cell is occupied! Choose another one!")
                    check = true
                    continue
                }
            }

            test = switch.substring(0,3)

        } while (check)

        if (test[0] == '1') {
            val idx = test[2].toString().toInt() - test[0].toString().toInt()

            val fin1 = board.substring(0, idx)
            val fin2 = board.substring(idx + 1)

            board = fin1 + player + fin2
            initGame(board)
        }

        else if (test[0] == '2') {
            val idx = test[2].toString().toInt() + test[0].toString().toInt()

            val fin1 = board.substring(0, idx)
            val fin2 = board.substring(idx + 1)

            board = fin1 + player + fin2
            initGame(board)
        }

        else {
            val idx = test[0].toString().toInt() * 2 + test[2].toString().toInt() - 1

            val fin1 = board.substring(0, idx)
            val fin2 = board.substring(idx + 1)

            board = fin1 + player + fin2
            initGame(board)
        }

        when {
            (board[0] == 'X' || board [0] == 'O') && board[0] == board[1] && board[1] == board[2] -> { print("${board[0]} wins"); break}
            (board[3] == 'X' || board [3] == 'O') && board[3] == board[4] && board[4] == board[5] -> { print("${board[3]} wins"); break}
            (board[6] == 'X' || board [6] == 'O') && board[6] == board[7] && board[7] == board[8] -> { print("${board[6]} wins"); break}

            (board[0] == 'X' || board [0] == 'O') && board[0] == board[3] && board[3] == board[6] -> { print("${board[0]} wins"); break}
            (board[1] == 'X' || board [1] == 'O') && board[1] == board[4] && board[4] == board[7] -> { print("${board[1]} wins"); break}
            (board[2] == 'X' || board [2] == 'O') && board[2] == board[5] && board[5] == board[8] -> { print("${board[2]} wins"); break}

            (board[0] == 'X' || board [0] == 'O') && board[0] == board[4] && board[4] == board[8] -> { print("${board[0]} wins"); break}
            (board[2] == 'X' || board [2] == 'O') && board[2] == board[4] && board[4] == board[6] -> { print("${board[2]} wins"); break}

            else -> {}
        }
    }
}