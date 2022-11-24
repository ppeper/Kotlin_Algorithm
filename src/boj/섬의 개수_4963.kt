package boj

import java.util.*

private val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
private val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
fun main() {
    val answer = mutableListOf<Int>()
    while (true) {
        val (w, h) = readLine()!!.split(' ').map { it.toInt() }
        if (w == 0 && h == 0) break
        val board = Array(h) { IntArray(h) }
        repeat(h) { index ->
            board[index] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
        }
        val visited = Array(h) { BooleanArray(w) }
        answer.add(checkLand(board, visited))
    }
    answer.forEach {
        println(it)
    }
}

private fun checkLand(board: Array<IntArray>, visited: Array<BooleanArray>): Int {
    var count = 0
    val queue = LinkedList<Pair<Int,Int>>()
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (!visited[i][j] && board[i][j] == 1) {
                queue.offer(Pair(i, j))
                while (queue.isNotEmpty()) {
                    val curr = queue.poll()
                    for (k in 0 until 8) {
                        val cx = curr.first + dx[k]
                        val cy = curr.second + dy[k]
                        if (cx in board.indices && cy in board[i].indices && !visited[cx][cy] && board[cx][cy] == 1) {
                            visited[cx][cy] = true
                            queue.offer(Pair(cx, cy))
                        }
                    }
                }
                count++
            }
        }
    }
    return count
}
