package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

private var N = 0
private var L = 0
private var R = 0
private var day = 0
private lateinit var board: Array<IntArray>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, l, r) = readLine().split(' ').map { it.toInt() }
    N = n
    L = l
    R = r
    board = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        val value = readLine().split(' ').map { it.toInt() }
        board[i] = value.toIntArray()
    }
    while (true) {
        var move = false
        val visited = Array(N) { BooleanArray(N) }
        for (i in board.indices) {
            for (j in board.indices) {
                if (!visited[i][j]) {
                    if (openArea(i, j, visited)) {
                        move = true
                    }
                }
            }
        }
        // 국경의 이동이 일어남
        if (move) {
            day++
        } else {
            break
        }
    }
    println(day)
}

private fun openArea(x: Int, y: Int, visited: Array<BooleanArray>): Boolean {
    val queue = LinkedList<Pair<Int, Int>>()
    val list = ArrayList<Pair<Int, Int>>()
    queue.offer(Pair(x, y))
    list.add(Pair(x, y))
    visited[x][y] = true
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        for (i in 0 until 4) {
            val cx = curr.first + dx[i]
            val cy = curr.second + dy[i]
            if (isValid(cx, cy)) {
                // 방문과 나라간의 차이가 L~R 사이라면
                if (!visited[cx][cy] && isRange(abs(board[curr.first][curr.second] - board[cx][cy]))) {
                    visited[cx][cy] = true
                    queue.offer(Pair(cx,cy))
                    list.add(Pair(cx,cy))
                }
            }
        }
    }
    // 국경이 열리지 않음
    return if (list.size == 1) {
        false
    } else {
        // 도시의 인구수 합 / 나라수
        val divide = list.sumOf { board[it.first][it.second] } / list.size
        for (area in list) {
            board[area.first][area.second] = divide
        }
        true
    }
}

private fun isRange(diff: Int): Boolean {
    return diff in L..R
}

private fun isValid(x: Int, y: Int): Boolean {
    return 0 <= x && x < board.size && 0 <= y && y < board.size
}

