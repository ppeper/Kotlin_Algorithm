package boj.Problem5427

import java.util.*

data class Point(val x: Int, val y: Int, val dist: Int)
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var min = Int.MAX_VALUE
private lateinit var board: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var fires: LinkedList<Pair<Int, Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n) {
        min = Int.MAX_VALUE
        val queue = LinkedList<Point>()
        fires = LinkedList<Pair<Int, Int>>()
        val (w, h) = readLine().split(" ").map { it.toInt() }
        board = Array(h) { CharArray(w) }
        visited = Array(h) { BooleanArray(w) }
        for (i in 0 until h) {
            val input = readLine().toCharArray()
            for (j in input.indices) {
                if (input[j] == '*') {
                    fires.add(Pair(i, j))
                    visited[i][j] = true
                } else if (input[j] == '@') {
                    visited[i][j] = true
                    queue.add(Point(i, j, 0))
                }
                board[i][j] = input[j]
            }
        }
        while (queue.isNotEmpty()) {
            val size = queue.size
            fireAround()
            for (i in 0 until size) {
                val (x, y, dist) = queue.poll()
                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    if (nx !in board.indices || ny !in board[0].indices) {
                        min = min.coerceAtMost(dist + 1)
                        break
                    }
                    if (!visited[nx][ny] && board[nx][ny] != '#') {
                        queue.offer(Point(nx, ny, dist + 1))
                        visited[nx][ny] = true
                    }
                }
            }
        }
        if (min != Int.MAX_VALUE) sb.append("$min\n") else sb.append("IMPOSSIBLE\n")
    }
    println(sb)
}

private fun fireAround() {
    val size = fires.size
    for (i in 0 until size) {
        val (x, y) = fires.poll()
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in board.indices || ny !in board[0].indices) continue
            if (board[nx][ny] != '#' && !visited[nx][ny]) {
                visited[nx][ny] = true
                fires.offer(Pair(nx, ny))
            }
        }
    }
}
