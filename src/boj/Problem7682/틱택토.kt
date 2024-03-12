package boj.Problem7682

private val answer = StringBuilder()
private lateinit var board: Array<CharArray>
fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val input = readLine()
        if (input == "end") break
        var xCount = 0
        var oCount = 0
        board = Array(3) { CharArray(3) { '.' } }
        for (i in 0 until 9) {
            board[i / 3][i % 3] = input[i]
            if (input[i] == 'X') xCount++
            if (input[i] == 'O') oCount++
        }
        if (isWin('X') && !isWin('O') && xCount - oCount == 1) {
            answer.append("valid\n")
        } else if (isWin('O') && !isWin('X') && xCount == oCount) {
            answer.append("valid\n")
        } else if (!isWin('X') && !isWin('O') && xCount - oCount == 1 && xCount + oCount == 9) {
            answer.append("valid\n")
        } else {
            answer.append("invalid\n")
        }
    }
    println(answer)
}

private fun isWin(a: Char): Boolean {
    for (i in 0 until 3) {
        // 가로
        if (board[i][0] == a &&
            board[i][0] == board[i][1] && board[i][1] == board[i][2]
        ) {
            return true
        }
        // 세로
        if (board[0][i] == a &&
            board[0][i] == board[1][i] && board[1][i] == board[2][i]
        ) {
            return true
        }
    }
    // 대각
    if (board[0][0] == a &&
        board[0][0] == board[1][1] && board[1][1] == board[2][2]
    ) {
        return true
    }
    if (board[0][2] == a &&
        board[0][2] == board[1][1] && board[1][1] == board[2][0]
    ) {
        return true
    }
    return false
}