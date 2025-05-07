package boj.Problem1012

import java.util.*

private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val answer = StringBuilder()
    var count: Int
    repeat(t) {
        count = 0
        val (m, n, k) = readLine().split(" ").map { it.toInt() }
        graph = Array(n) { IntArray(m) }
        visited = Array(n) { BooleanArray(m) }
        repeat(k) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            graph[b][a] = 1
        }
        for (i in graph.indices) {
            for (j in graph[0].indices) {
                if (visited[i][j]) continue
                if (graph[i][j] == 0) continue
                bfs(i, j)
                count++
            }
        }
        answer.append("$count\n")
    }
    println(answer)
}

private fun bfs(i: Int, j: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(i, j))
    visited[i][j] = true
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (d in 0 until 4) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx !in graph.indices || ny !in graph[0].indices) continue
            if (visited[nx][ny]) continue
            if (graph[nx][ny] == 0) continue
            visited[nx][ny] = true
            queue.add(Pair(nx, ny))
        }
    }
}
