package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

data class Person(
    val x: Int,
    val y: Int,
    val favorite: Int,
    val empty: Int
) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return if (this.favorite == other.favorite) {
            if (this.empty == other.empty) {
                if (this.x == other.x) {
                    this.y - other.y
                } else {
                    this.x - other.x
                }
            } else {
                other.empty - this.empty
            }
        } else {
            other.favorite - this.favorite
        }
    }
}
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var board: Array<IntArray>
private lateinit var favoriteMap: HashMap<Int, List<Int>>
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    board = Array(size) { IntArray(size) }
    favoriteMap = HashMap()
    // 학생의 자리 정해주기
    for (i in 0 until size * size) {
        val input = readLine().split(' ').map { it.toInt() }
        val favorite = input.filter { it != input[0] }
        favoriteMap[input[0]] = favorite
        val person = setUpPerson(favorite)
        // 자리 착석
        board[person.x][person.y] = input[0]
    }
    println(calculateScore())
}

private fun calculateScore(): Int {
    var score = 0
    for (i in board.indices) {
        for (j in board.indices) {
            var count = 0
            val favorite = favoriteMap[board[i][j]]
            for (k in 0 until 4) {
                val cx = i + dx[k]
                val cy = j + dy[k]
                if (isValid(cx, cy)) {
                    if (favorite!!.contains(board[cx][cy])) {
                        count++
                    }
                }
            }
            when (count) {
                1 -> score += 1
                2 -> score += 10
                3 -> score += 100
                4 -> score += 1000
            }
        }
    }
    return score
}

private fun setUpPerson(favorite: List<Int>): Person {
    val pq = PriorityQueue<Person>()
    for (i in board.indices) {
        for (j in board.indices) {
            if (board[i][j] == 0) {
                var favor = 0
                var empty = 0
                for (k in 0 until 4) {
                    val cx = i + dx[k]
                    val cy = j + dy[k]
                    if (isValid(cx, cy)) {
                        if (favorite.contains(board[cx][cy])) {
                            favor++
                        } else {
                            if (board[cx][cy] == 0) {
                                empty++
                            }
                        }
                    }
                }
                // 빈방과 좋아하는 사람의 방에 값에 따라 우선순위 큐에 넢어줌
                pq.offer(Person(i, j, favor, empty))
            }
        }
    }
    return pq.poll()
}

private fun isValid(x: Int, y: Int): Boolean {
    return x in board.indices && y in board.indices
}
