package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class FireBall(
    var x: Int,
    var y: Int,
    var m: Int,
    var s: Int,
    var d: Int
)
private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
private lateinit var board: Array<Array<LinkedList<FireBall>>>
private lateinit var fireBall: ArrayList<FireBall>
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, K) = readLine().split(' ').map { it.toInt() }
    board = Array(N) { Array(N) { LinkedList() } }
    fireBall = ArrayList()
    // M개의 파이어볼
    for (i in 0 until M) {
        val input = readLine().split(' ').map { it.toInt() }
        // 파이어볼
        val fireball = FireBall(input[0] - 1, input[1] - 1, input[2], input[3], input[4])
        fireBall.add(fireball)
    }
    // K번 이동
    repeat(K) {
        moveFireball()
        // 겹치는 파이어볼 4개로 나누어짐
        checkFireBall()
    }
    println(remainFireBall())
}

private fun remainFireBall(): Int {
    var weight = 0
    for (i in fireBall.indices) {
        weight += fireBall[i].m
    }
    return weight
}

private fun checkFireBall() {
    for (i in board.indices) {
        for (j in board.indices) {
            // 파이어 볼이 있음
            if (1 < board[i][j].size) {
                fireBallSplit(i, j)
            } else {
                board[i][j].clear()
            }
        }
    }
}

private fun fireBallSplit(x: Int, y: Int) {
    val list = board[x][y]
    val size = list.size
    var sumM = 0
    var sumS = 0
    var odd = true
    var even = true
    while (list.isNotEmpty()) {
        val curr = list.poll()
        sumM += curr.m
        sumS += curr.s
        if (curr.d % 2 == 0) {
            odd = false
        } else {
            even = false
        }
        fireBall.remove(curr)
    }
    // 파이어볼 나누기
    if (sumM / 5 == 0) {
        return
    } else {
        // true -> 모두 짝수 or 모두 홀수 -> 0,2,4,8
        if (odd || even) {
            for (i in 0..6 step 2) {
                fireBall.add(FireBall(x, y, sumM / 5, sumS / size, i))
            }
        } else {
            for (i in 1..7 step 2) {
                fireBall.add(FireBall(x, y, sumM / 5, sumS / size, i))
            }
        }
    }
}

private fun moveFireball() {
    for (f in fireBall) {
        f.x = (f.x + board.size + dx[f.d] * (f.s % board.size)) % board.size
        f.y = (f.y + board.size + dy[f.d] * (f.s % board.size)) % board.size
        board[f.x][f.y].add(f)
    }
}
