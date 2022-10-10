package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Number(
    val number: Int,
    val count: Int
): Comparable<Number> {
    override fun compareTo(other: Number): Int {
        if (this.count == other.count) {
            // 수가 커지는 순
            return this.number - other.number
        }
        // 등장 횟수가 커지는 순
        return this.count - other.count
    }
}

private lateinit var board: Array<IntArray>
private var R = 3
private var C = 3
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (r, c, k) = readLine().split(' ').map { it.toInt() }
    board = Array(101) { IntArray (101) }
    var time = 0
    for (i in 0 until 3) {
        val input = readLine().split(' ').map { it.toInt() }
        for (j in input.indices) {
            board[i][j] = input[j]
        }
    }
    while (time <= 100) {
        if (board[r-1][c-1] == k) {
            break
        }
        if (C <= R) {
            sortRow()
        } else {
            sortColumn()
        }
        time++
    }

    if (100 < time) println(-1) else println(time)
}

private fun sortRow() {
    val list = PriorityQueue<Number>()
    val count = IntArray(101)
    for (i in 0 until R) {
        for (j in 0 until C) {
            if (board[i][j] != 0) {
                count[board[i][j]]++
                board[i][j] = 0
            }
        }
        // 우선순위로 정렬
        for (k in count.indices) {
            if (count[k] != 0) {
                list.add(Number(k, count[k]))
                count[k] = 0
            }
        }
        var index = 0
        // 바뀐 배열로 수정
        while (list.isNotEmpty()) {
            val curr = list.poll()
            board[i][index++] = curr.number
            board[i][index++] = curr.count
        }
        // 길이에 따라 업데이트
        C = C.coerceAtLeast(index)
    }
}

private fun sortColumn() {
    val list = PriorityQueue<Number>()
    val count = IntArray(101)
    for (i in 0 until C) {
        for (j in 0 until R) {
            if (board[j][i] != 0) {
                count[board[j][i]]++
                board[j][i] = 0
            }
        }
        // 우선순위로 정렬
        for (k in count.indices) {
            if (count[k] != 0) {
                list.add(Number(k, count[k]))
                count[k] = 0
            }
        }
        var index = 0
        // 바뀐 배열로 수정
        while (list.isNotEmpty()) {
            val curr = list.poll()
            board[index++][i] = curr.number
            board[index++][i] = curr.count
        }
        // 길이에 따라 업데이트
        R = R.coerceAtLeast(index)
    }
}