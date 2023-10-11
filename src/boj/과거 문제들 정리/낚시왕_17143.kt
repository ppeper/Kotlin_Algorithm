package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Shark(
    var r: Int,
    var c: Int,
    var s: Int,
    var d: Int,
    var z: Int
)
private var sumOfSharkSize = 0
private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private val sharks = LinkedList<Shark>()
private lateinit var board: Array<Array<Shark?>>
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (R, C, M) = readLine().split(' ').map { it.toInt() }
    board = Array(R) { Array(C) { null } }
    for (i in 0 until M) {
        val (r,c,s,d,z) = readLine().split(' ').map { it.toInt() }
        val shark = Shark(r-1, c-1, s,d-1,z)
        board[r-1][c-1] = shark
    }
    // 상어 잡기
    for (pos in 0 until board[0].size) {
        catchShark(pos)
        moveShark()
    }
    println(sumOfSharkSize)
}

private fun moveShark() {
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] != null) {
                sharks.offer(board[i][j])
                board[i][j] = null
            }
        }
    }
    // 상어 이동하기
    while (sharks.isNotEmpty()) {
        val shark = sharks.poll()
        var cx = shark.r
        var cy = shark.c
        var speed = shark.s
        // 이동 줄이기
        speed %= if (shark.d in 0..1) {
            (board.size - 1) * 2
        } else {
            (board[0].size - 1) * 2
        }
        // 상어 이동하기
        while (0 < speed) {
            cx += dx[shark.d]
            cy += dy[shark.d]
            if (!isValid(cx, cy)) {
                cx -= dx[shark.d]
                cy -= dy[shark.d]
                shark.d = changeDirection(shark.d)
            } else {
                speed--
            }
        }
        val s = Shark(cx, cy, shark.s, shark.d, shark.z)
        // 큰상어만 남김
        if (board[cx][cy] != null) {
            // 더 큰 상어
            if (board[cx][cy]!!.z < shark.z) {
                board[cx][cy] = s
            }
        } else {
            board[cx][cy] = s
        }
    }
}

private fun catchShark(pos: Int) {
    for (i in board.indices) {
        if (board[i][pos] != null) {
            val shark = board[i][pos]
            board[i][pos] = null
            sumOfSharkSize += shark!!.z
            break
        }
    }
}

private fun changeDirection(d: Int): Int {
    return when (d) {
        0 -> 1
        1 -> 0
        2 -> 3
        else -> 2
    }
}

private fun isValid(x: Int, y: Int): Boolean {
    return x in board.indices && y in board[0].indices
}
