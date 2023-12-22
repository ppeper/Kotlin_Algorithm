package boj.Problem1926

import java.util.*

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var count = 0
private var width = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }
    repeat(n) {
        graph[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!visited[i][j] && graph[i][j] == 1) {
                bfs(i, j)
            }
        }
    }
    println(count)
    println(width)
}

private fun bfs(i: Int, j: Int) {
    var size = 1
    val q = LinkedList<Pair<Int, Int>>()
    q.add(Pair(i, j))
    visited[i][j] = true
    while (q.isNotEmpty()) {
        val curr = q.poll()
        for (k in 0 until 4) {
            val nx = curr.first + dx[k]
            val ny = curr.second + dy[k]
            if (nx !in graph.indices || ny !in graph[0].indices) continue
            if (visited[nx][ny]) continue
            if (graph[nx][ny] == 0) continue
            visited[nx][ny] = true
            size++
            q.add(Pair(nx, ny))
        }
    }
    count++
    width = width.coerceAtLeast(size)
}
