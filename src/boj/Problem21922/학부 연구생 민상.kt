package boj.Problem21922

import java.util.*

data class Node(
    val x: Int,
    val y: Int,
    val dir: Int
)
private lateinit var board: Array<IntArray>
private lateinit var airConditional: MutableList<Pair<Int, Int>>
private lateinit var visited: Array<Array<BooleanArray>>
// 우, 하, 좌, 상
private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)
fun main() = with(System.`in`.bufferedReader()) {
    var count = 0
    val (n, m) = readLine().split(" ").map { it.toInt() }
    board = Array(n) { IntArray(m) }
    visited = Array(4) { Array(n) { BooleanArray(m) } }
    airConditional = mutableListOf()
    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }.toIntArray()
        board[it] = input
        for (i in input.indices) {
            if (input[i] == 9) {
                airConditional.add(Pair(it, i))
            }
        }
    }
    airConditional.forEach { (a, b) ->
        search(a, b)
    }
        for (i in 0 until n) {
            for (j in 0 until m) {
                for (k in 0 until 4) {
                    if (visited[k][i][j]) {
                        count++
                        break
                    }
                }
            }
        }
    println(count)
}

private fun search(a: Int, b: Int) {
    val queue: Queue<Node> = LinkedList()
    for (i in 0 until 4) {
        queue.add(Node(a, b, i))
        visited[i][a][b] = true
    }
    while (queue.isNotEmpty()) {
        val (x, y, dir) = queue.poll()
        val nx = x + dx[dir]
        val ny = y + dy[dir]
        if (nx !in board.indices || ny !in board[0].indices) continue
        val ndir = changeDir(board[nx][ny], dir)
        if (visited[ndir][nx][ny]) continue
        visited[ndir][nx][ny] = true
        queue.add(Node(nx, ny, ndir))
    }
}

private fun changeDir(shape: Int, dir: Int): Int {
    when (shape) {
        0 -> return dir
        1 -> {
            return when (dir) {
                0 -> 2
                2 -> 0
                else -> dir
            }
        }
        2 -> {
            return when (dir) {
                1 -> 3
                3 -> 1
                else -> dir
            }
        }
        3 -> {
            return when (dir) {
                0 -> 3
                1 -> 2
                2 -> 1
                else -> 0
            }
        }
        4 -> {
            return when (dir) {
                0 -> 1
                1 -> 0
                2 -> 3
                else -> 2
            }
        }
        else -> {
            return when (dir) {
                0 -> 2
                2 -> 0
                1 -> 3
                else -> 1
            }
        }
    }
}
