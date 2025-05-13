package boj.Problem17836

import java.util.LinkedList
import kotlin.math.min

data class Node(
    val x: Int,
    val y: Int,
)
private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)
private lateinit var graph: Array<IntArray>
private lateinit var distance: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, t) = readLine().split(" ").map { it.toInt() }
    var x = 0
    var y = 0
    graph = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        val input = readLine().split(" ").map { it.toInt() }
        graph[i] = input.toIntArray()
        for (j in 0 until m) {
            if (input[j] == 2) {
                x = i
                y = j
            }
        }
    }
    distance = Array(n) { IntArray(m) { 0 } }
    val queue = LinkedList<Node>()
    queue.add(Node(0, 0))
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx !in graph.indices || ny !in graph[0].indices) continue
            if (distance[nx][ny] != 0) continue
            if (graph[nx][ny] != 1) {
                distance[nx][ny] = distance[x][y] + 1
                queue.add(Node(nx, ny))
            }
        }
    }
    val time1 = if (distance[n - 1][m - 1] != 0) distance[n - 1][m - 1] else Int.MAX_VALUE
    val time2 = if (distance[x][y] != 0) distance[x][y] + n - x - 1 + m - y - 1 else Int.MAX_VALUE
    val minTime = min(time1, time2)
    if (t < minTime) println("Fail") else println(minTime)
}