package boj.Problem4179

import java.util.LinkedList

data class Node(
    val x: Int,
    val y: Int,
    val time: Int
)
const val IMPOSSIBLE = "IMPOSSIBLE"
const val FIRE = 'F'
const val VALID = '.'
const val WALL = '#'
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var startX = 0
private var startY = 0
private lateinit var graph: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var fire: LinkedList<Pair<Int, Int>>
var answer = Int.MAX_VALUE
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    fire = LinkedList()
    graph = Array(n) { CharArray(m) }
    visited = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        val input = readLine().toCharArray()
        graph[i] = input
        for (j in input.indices) {
            if (input[j] == FIRE) {
                fire.add(Pair(i, j))
            }
            if (input[j] == 'J') {
                startX = i
                startY = j
            }
        }
    }
    val queue = LinkedList<Node>()
    queue.add(Node(startX, startY, 0))
    visited[startX][startY] = true
    while (queue.isNotEmpty()) {
        fireSpread()
        val size = queue.size
        for (i in 0 until size) {
            val (x, y, time) = queue.poll()
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                // 탈출
                if (nx !in 0 until n || ny !in 0 until m) {
                    answer = answer.coerceAtMost(time + 1)
                    break
                }
                if (graph[nx][ny] == WALL || graph[nx][ny] == FIRE) continue
                if (visited[nx][ny]) continue
                visited[nx][ny] = true
                queue.add(Node(nx, ny, time + 1))
            }
        }
    }
    if (answer == Int.MAX_VALUE) println(IMPOSSIBLE) else println(answer)
}

private fun fireSpread() {
    val size = fire.size
    for (i in 0 until size) {
        val (x, y) = fire.poll()
        for (j in 0 until 4) {
            val nx = x + dx[j]
            val ny = y + dy[j]
            if (nx !in graph.indices || ny !in graph[0].indices) continue
            if (graph[nx][ny] == WALL || graph[nx][ny] == FIRE) continue
            graph[nx][ny] = FIRE
            fire.add(Pair(nx, ny))
        }
    }
}