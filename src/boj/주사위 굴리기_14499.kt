package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private val dx = intArrayOf(0, 0, -1, 1)
private val dy = intArrayOf(1, -1, 0, 0)
private lateinit var dice: IntArray
private lateinit var board: Array<IntArray>
private lateinit var oper: List<Int>
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(' ').map { it.toInt() }
    var x = input[2]
    var y = input[3]
    // 처음 주사위 모양
    dice = intArrayOf(0, 0, 0, 0, 0, 0)
    board = Array(input[0]) { IntArray(input[1]) }
    // Map init
    for (i in 0 until input[0]) {
        board[i] = readLine().split(' ').map { it.toInt() }.toIntArray()
    }
    oper = readLine().split(' ').map { it.toInt() }
    // 주사위 굴리기
    for (op in oper) {
        val cx = x + dx[op - 1]
        val cy = y + dy[op - 1]
        // 맵을 벗어나지 않음
        if (isValid(cx, cy)) {
            roll(op)
            x = cx
            y = cy
            if (board[cx][cy] == 0) {
                board[cx][cy] = dice[5]
            } else {
                dice[5] = board[cx][cy]
                board[cx][cy] = 0
            }
            println(dice[0])
        }
    }
}

// 주사위 모양 바꾸기
private fun roll(i: Int) {
    val temp = dice.clone()
    when (i) {
        // 동
        1 -> {
            dice[0] = temp[3]
            dice[1] = temp[1]
            dice[2] = temp[0]
            dice[3] = temp[5]
            dice[4] = temp[4]
            dice[5] = temp[2]
        }
        // 서
        2 -> {
            dice[0] = temp[2]
            dice[1] = temp[1]
            dice[2] = temp[5]
            dice[3] = temp[0]
            dice[4] = temp[4]
            dice[5] = temp[3]
        }
        // 남
        3 -> {
            dice[0] = temp[4]
            dice[1] = temp[0]
            dice[2] = temp[2]
            dice[3] = temp[3]
            dice[4] = temp[5]
            dice[5] = temp[1]
        }
        // 북
        4 -> {
            dice[0] = temp[1]
            dice[1] = temp[5]
            dice[2] = temp[2]
            dice[3] = temp[3]
            dice[4] = temp[0]
            dice[5] = temp[4]
        }
    }
}

private fun isValid(x: Int, y: Int): Boolean {
    return x >= 0 && x < board.size && y >= 0 && y < board[0].size
}
