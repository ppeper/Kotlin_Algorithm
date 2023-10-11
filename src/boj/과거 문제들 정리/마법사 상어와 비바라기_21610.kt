package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
private val dx = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)
private val dy = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private var N = 0
private lateinit var board: Array<IntArray>
private lateinit var cloudState: Array<BooleanArray>
private lateinit var clouds: LinkedList<Pair<Int, Int>>
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, M) = readLine().split(' ').map { it.toInt() }
    N = n
    board = Array(N) { IntArray(N) }
    cloudState = Array(N) { BooleanArray(N) }
    clouds = LinkedList()
    init()
    for (i in 0 until N) {
        val value = readLine().split(' ').map { it.toInt() }.toIntArray()
        board[i] = value
    }
    for (j in 0 until M) {
        val (direction, move) = readLine().split(' ').map { it.toInt() }
        moveCloud(direction - 1, move)
        rain()
        cloudCreate()
    }
    println(calculateWater())
}


private fun cloudCreate() {
    for (i in board.indices) {
        for (j in board.indices) {
            if (cloudState[i][j]) {
                cloudState[i][j] = false
            } else if (2 <= board[i][j]) {
                board[i][j] -= 2
                clouds.offer(Pair(i, j))
            }
        }
    }
}

private fun rain() {
    for (i in 0 until clouds.size) {
        val (x, y) = clouds.poll()
        board[x][y] += 1
        clouds.addLast(Pair(x, y))
    }
    // 대각선 방향으로 물이 있으면 추가
    while (clouds.isNotEmpty()) {
        val (x, y) = clouds.poll()
        var count = 0
        for (j in 1..7 step 2) {
            val cx = x + dx[j]
            val cy = y + dy[j]
            if (isValid(cx, cy)) {
                if (board[cx][cy] != 0) {
                    count++
                }
            }
        }
        // 물 추가
        board[x][y] += count
    }
}

private fun moveCloud(direction: Int, move: Int) {
    for (i in 0 until clouds.size) {
        val (x, y) = clouds.poll()
        var cx = x + dx[direction] * (move % N)
        var cy = y + dy[direction] * (move % N)
        if (N <= cx) cx -= N
        if (N <= cy) cy -= N
        if (cx < 0) cx += N
        if (cy < 0) cy += N
        cloudState[cx][cy] = true
        clouds.addLast(Pair(cx, cy))
    }
}

private fun calculateWater(): Int {
    return board.sumOf { it.sum() }
}

private fun init() {
    with(clouds) {
        offer(Pair(N -1,0))
        offer(Pair(N -1,1))
        offer(Pair(N -2,0))
        offer(Pair(N -2,1))
    }
}

private fun isValid(x: Int, y: Int): Boolean {
    return x in board.indices && y in board.indices
}

