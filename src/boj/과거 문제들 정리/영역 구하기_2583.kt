package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)
private lateinit var board: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var list: ArrayList<Int>
var count = 0
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    list = ArrayList()
    val input = readLine().split(' ').map { it.toInt() }
    board = Array(input[0]) { IntArray(input[1]) }
    visited = Array(input[0]) { BooleanArray(input[1]) }
    for (i in 0 until input[2]) {
        val range = readLine().split(' ').map { it.toInt() }
        for (a in range[1] until range[3]) {
            for (b in range[0] until range[2]) {
                board[a][b] = 1
            }
        }
    }
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (!visited[i][j] && board[i][j] == 0) {
                list.add(checkMap(i, j))
                count++
            }
        }
    }
    println(count)
    for (value in list.sorted()) {
        print("$value ")
    }
}

private fun checkMap(i: Int, j: Int): Int {
    var size = 1
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.offer(Pair(i, j))
    visited[i][j] = true
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        for (i in 0 until 4) {
            val cx = curr.first + dx[i]
            val cy = curr.second + dy[i]
            if (isValid(cx, cy)) {
                if (!visited[cx][cy] && board[cx][cy] == 0) {
                    visited[cx][cy] = true
                    queue.offer(Pair(cx, cy))
                    size++
                }
            }
        }
    }
    return size
}

private fun isValid(x: Int, y: Int): Boolean {
    return 0 <= x && x < board.size && 0 <= y && y < board[0].size
}

