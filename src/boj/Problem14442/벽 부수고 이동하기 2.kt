package boj.Problem14442

import java.util.LinkedList

data class Node(
    val x: Int,
    val y: Int,
    val count: Int = 0,
    val move: Int = 1
)
private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<Array<BooleanArray>>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var N = 0
private var M = 0
private var K = 0
private var answer = Int.MAX_VALUE
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    K = k
    visited = Array(k + 1) { Array(n) { BooleanArray(m)} }
    graph = Array(n) {readLine().toCharArray().map { it - '0' }.toIntArray() }
    bfs(0, 0)
    if (answer == Int.MAX_VALUE) println(-1) else println(answer)
}

private fun bfs(startX: Int, startY: Int) {
    val queue = LinkedList<Node>()
    queue.add(Node(startX, startY))
    visited[0][startX][startY] = true
    while(queue.isNotEmpty()) {
        val curr = queue.poll()
        if (curr.x == N - 1 && curr.y == M - 1) {
            answer = answer.coerceAtMost(curr.move)
            break
        }
        for (i in 0 until 4) {
            val nx = curr.x + dx[i]
            val ny = curr.y + dy[i]
            if (nx !in 0 until N || ny !in 0 until M) continue
            if (graph[nx][ny] == 0 && !visited[curr.count][nx][ny]) {
                queue.add(Node(nx, ny, curr.count, curr.move + 1))
                visited[curr.count][nx][ny] = true
            } else {
                if (curr.count < K && !visited[curr.count][nx][ny]) {
                    queue.add(Node(nx, ny, curr.count + 1, curr.move + 1))
                    visited[curr.count + 1][nx][ny] = true
                }
            }
        }
    }
}