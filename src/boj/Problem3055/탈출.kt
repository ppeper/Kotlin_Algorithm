package boj.Problem3055

import java.util.*

data class Node(
    val x: Int,
    val y: Int,
    val time: Int = 0
)
private lateinit var graph: Array<CharArray>
private lateinit var queue: Queue<Node>
private lateinit var water: Queue<Node>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var answer = Int.MAX_VALUE
fun main() = with(System.`in`.bufferedReader()) {
    queue = LinkedList()
    water = LinkedList()
    val (r, c) = readLine().split(" ").map { it.toInt() }
    graph = Array(r) { readLine().toCharArray() }
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == 'S') {
                queue.offer(Node(i, j))
            }
            if (graph[i][j] == '*') {
                water.offer(Node(i, j))
            }
        }
    }
    bfs()
    if (answer == Int.MAX_VALUE) println("KAKTUS") else println(answer)
}

private fun bfs() {
    while (queue.isNotEmpty()) {
        repeat(water.size) {
            val (x, y, _) = water.poll()
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx !in graph.indices || ny !in graph[0].indices) continue
                if (graph[nx][ny] == '.') {
                    graph[nx][ny] = '*'
                    water.offer(Node(nx, ny))
                }
            }
        }
        repeat(queue.size) {
            val (x, y, time) = queue.poll()
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx !in graph.indices || ny !in graph[0].indices) continue
                if (graph[nx][ny] == 'D') {
                    answer = answer.coerceAtMost(time + 1)
                    return
                }
                if (graph[nx][ny] == '.') {
                    graph[nx][ny] = 'S'
                    queue.offer(Node(nx, ny, time + 1))
                }
            }
        }
    }
}
