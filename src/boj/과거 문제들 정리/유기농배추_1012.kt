package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)
private lateinit var board: Array<IntArray>
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val test = readLine().toInt()
    for (t in 0 until test) {
        val input = readLine().split(' ').map { it.toInt() }
        board = Array(input[1]) { IntArray(input[0]) }
        val visited = Array(input[1]) { BooleanArray(input[0]) }
        // 배추들의 위치
        for (i in 0 until input[2]) {
            val pos = readLine().split(' ').map { it.toInt() }
            board[pos[1]][pos[0]] = 1
        }
        println(bfs(visited))
    }
}

private fun bfs(visited: Array<BooleanArray>): Int {
    var count = 0
    val queue: Queue<Pair<Int,Int>> = LinkedList()
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (!visited[i][j] && board[i][j] == 1) {
                queue.offer(Pair(i, j))
                while (queue.isNotEmpty()) {
                    val curr = queue.poll()
                    for (i in 0 until 4) {
                        val cx = curr.first + dx[i]
                        val cy = curr.second + dy[i]
                        if (isValid(cx, cy)) {
                            if (!visited[cx][cy] && board[cx][cy] == 1) {
                                visited[cx][cy] = true
                                queue.offer(Pair(cx, cy))
                            }
                        }
                    }
                }
                count++
            }
        }
    }
    return count
}

private fun isValid(x: Int, y: Int): Boolean {
    return 0 <= x && x < board.size && 0 <= y && y < board[0].size
}
