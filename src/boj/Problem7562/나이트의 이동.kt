package boj.Problem7562

import java.util.LinkedList

data class Node(
    val x: Int,
    val y: Int,
    val move: Int = 0
)
private val answer = StringBuilder()
private val dx = intArrayOf(2, 2, -2, -2, 1, 1, -1, -1)
private val dy = intArrayOf(1, -1, 1, -1, 2, -2, 2, -2)
private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var queue: LinkedList<Node>
fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        graph = Array(n) { IntArray(n) }
        visited = Array(n) { BooleanArray(n) }
        queue = LinkedList()
        val (startX, startY) = readLine().split(" ").map { it.toInt() }
        val (endX, endY) = readLine().split(" ").map { it.toInt() }
        answer.append(minMove(startX, startY, endX, endY)).append("\n")
    }
    println(answer)
}

private fun minMove(
    startX: Int,
    startY: Int,
    endX: Int,
    endY: Int
): Int {
    var min = Int.MAX_VALUE
    queue.add(Node(startX, startY))
    visited[startX][startY] = true
    while (queue.isNotEmpty()) {
        val (x, y, move) = queue.poll()
        if (x == endX && y == endY) {
            min = min.coerceAtMost(move)
            break
        }
        for (i in 0 until 8) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in graph.indices || ny !in graph.indices) continue
            if (visited[nx][ny]) continue
            visited[nx][ny] = true
            queue.add(Node(nx, ny, move + 1))
        }
    }
    return if (min == Int.MAX_VALUE) 0 else min
}