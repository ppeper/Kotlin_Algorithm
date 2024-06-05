package boj.Problem1113

import java.util.LinkedList

private lateinit var board: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var answer = 0
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    board = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        val input = readLine().toCharArray()
        for (j in input.indices) {
            board[i][j] = input[j] - '0'
        }
    }
    for (height in 1..9) {
        visited = Array(n) { BooleanArray(m) }
        for (i in 1 until n - 1) {
            for (j in 1 until m - 1) {
                if (board[i][j] <= height && !visited[i][j]) {
                    bfs(i, j, height)
                }
            }
        }
    }
    println(answer)
}

private fun bfs(i: Int, j: Int, height: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(i, j))
    visited[i][j] = true
    var flag = true
    var count = 1

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in board.indices || ny !in board[0].indices) {
                flag = false
                continue
            }
            if (visited[nx][ny]) continue
            if (board[nx][ny] <= height) {
                visited[nx][ny] = true
                queue.add(Pair(nx, ny))
                count++
            }
        }
    }
    if (flag) answer += count
}
