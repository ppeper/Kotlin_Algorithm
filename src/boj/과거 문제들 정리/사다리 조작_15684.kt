package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var board: Array<IntArray>
private var min = 0
private var check = false
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, H) = readLine().split(' ').map { it.toInt() }
    board = Array(H) { IntArray(N) }
    for (i in 0 until M) {
        val input = readLine().split(' ').map { it.toInt() }
        // 오른쪽
        board[input[0]-1][input[1]-1] = 1
        // 왼쪽
        board[input[0]-1][input[1]] = 2
    }
    for (i in 0..3) {
        min = i
        drawLine(0)
        if (check) break
    }
    if (check) println(min) else println(-1)
}

private fun drawLine(line: Int) {
    if (check) {
        return
    }
    if (line == min) {
        if (checkBoard()) {
            check = true
        }
        return
    }
    for (i in board.indices) {
        for (j in 0 until board[0].size - 1) {
            // 사다리 줄 추가가능 여부
            if (board[i][j] == 0 && board[i][j + 1] == 0) {
                // 오른쪽
                board[i][j] = 1
                // 왼쪽
                board[i][j + 1] = 2
                drawLine(line + 1)
                board[i][j] = 0
                board[i][j + 1] = 0
            }
        }
    }
}

private fun checkBoard(): Boolean {
    for (i in board[0].indices) {
        var row = 0
        var col = i
        // 사다리 타기
        while (row < board.size) {
            // 우측 이동
            if (board[row][col] == 1) {
                col++
            } else if (board[row][col] == 2) {
                col--
            }
            row++
        }
        // 사다리가 도착했을때 i == col 확인
        if (i != col) return false
    }
    return true
}
