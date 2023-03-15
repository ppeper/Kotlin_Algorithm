package boj.완전탐색

import java.util.*
import kotlin.system.exitProcess

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var map: Array<IntArray>
private lateinit var visited: Array<Array<BooleanArray>>
private var K = 0
data class State(
    var x: Int,
    var y: Int,
    var canMove: Boolean,
    var brick: Int,
    var move: Int
    ) : Comparable<State> {
    override fun compareTo(other: State): Int {
        return this.move - other.move
    }
}
fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    K = k
    map = Array(n) { IntArray(m) }
    visited = Array(n) { Array(m) { BooleanArray(k + 1) } }
    for (i in 0 until n) {
        val input = readLine()!!
        for (j in input.indices) {
            map[i][j] = input[j] - '0'
        }
    }
    moveMap(State(0, 0, true, 0, 1))
    println(-1)
}

private fun moveMap(s: State) {
    val queue = PriorityQueue<State>()
    queue.offer(s)
    visited[s.x][s.y][s.brick] = true
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        if (curr.x == map.size - 1 && curr.y == map[0].size - 1) {
            println(curr.move)
            exitProcess(0)
        }
        for (i in 0 until 4) {
            val nx = curr.x + dx[i]
            val ny = curr.y + dy[i]
            if (nx < 0 || map.size <= nx || ny < 0 || map[0].size <= ny) continue
            // 낮일때 벽이 없음
            if (map[nx][ny] == 0 && !visited[nx][ny][curr.brick]) {
                visited[nx][ny][curr.brick] = true
                queue.offer(State(nx, ny, !curr.canMove, curr.brick, curr.move + 1))
            } else if (map[nx][ny] == 1 && curr.brick < K) {
                if (!visited[nx][ny][curr.brick + 1]) {
                    if (curr.canMove) {
                        visited[nx][ny][curr.brick + 1] = true
                        queue.offer(State(nx, ny, !curr.canMove, curr.brick + 1, curr.move + 1))
                    } else {
                        queue.offer(State(curr.x, curr.y, !curr.canMove, curr.brick, curr.move + 1))
                    }
                }
            }
        }
    }
}