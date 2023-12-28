package boj.Problem1245

import java.util.LinkedList

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
private val dy = intArrayOf(1, 1, 1, 0, 0, -1, -1, -1)
private var count = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        graph[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j]) bfs(i, j, graph[i][j])
        }
    }
    println(count)
}

private fun bfs(i: Int, j: Int, height: Int) {
    var check = true
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(i, j))
    visited[i][j] = true
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (k in 0 until 8) {
            val nx = x + dx[k]
            val ny = y + dy[k]
            if (nx !in graph.indices || ny !in graph[0].indices) continue
            if (height < graph[nx][ny]) check = false
            if (!visited[nx][ny] && graph[nx][ny] == height) {
                visited[nx][ny] = true
                queue.add(Pair(nx, ny))
            }
        }
    }
    if (check) count++
}
