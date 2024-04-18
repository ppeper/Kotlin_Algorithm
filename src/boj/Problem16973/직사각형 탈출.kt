package boj.Problem16973

import java.util.*

data class Node(
    val x: Int,
    val y: Int,
    val move: Int
)
private lateinit var board: Array<List<Int>>
private lateinit var visited: Array<BooleanArray>
private lateinit var rectangleSum: Array<IntArray>
// 하우상좌
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var H = 0
private var W = 0
private var answer = -1
private
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    board = Array(n) { readLine().split(" ").map { it.toInt() }}
    rectangleSum = Array(n + 1) { IntArray(m + 1) }
    for (i in 1..n) {
        for (j in 1..m) {
            rectangleSum[i][j] = rectangleSum[i - 1][j] + rectangleSum[i][j - 1] - rectangleSum[i - 1][j - 1] + board[i - 1][j - 1]
        }
    }
    visited = Array(n) { BooleanArray(m) }
    val input = readLine().split(" ").map { it.toInt() }
    H = input[0]
    W = input[1]
    moveRectangle(input[2] - 1, input[3] - 1, input[4] - 1, input[5] - 1)
    println(answer)
}

private fun moveRectangle(startX: Int, startY: Int, targetX: Int, targetY: Int) {
    val q = LinkedList<Node>()
    q.add(Node(startX, startY, 0))
    visited[startX][startY] = true
    while (q.isNotEmpty()) {
        val (x, y, move) = q.poll()
        if (x == targetX && y == targetY) {
            answer = move
            break
        }
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            val x1 = nx + H
            val y1 = ny + W
            if (nx < 0 || ny < 0 || board.size < x1 || board[0].size < y1) continue
            // 사각형안에 벽이 있는지 확인
            if (visited[nx][ny]) continue
            if (0 < rectangleSum[x1][y1] - rectangleSum[nx][y1] - rectangleSum[x1][ny] + rectangleSum[nx][ny]) continue
            q.add(Node(nx, ny, move + 1))
            visited[nx][ny] = true
        }
    }
}