package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var map: Array<IntArray>
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(' ').map { it.toInt() }
    var year = 0
    map = Array(input[0]) { IntArray(input[1]) }
    for (i in 0 until input[0]) {
        map[i] = readLine().split(' ').map { it.toInt() }.toIntArray()
    }
    while (true) {
        year++
        if (!melting()) {
            year = 0
            break
        }
        // 첫번째 나눠지는 시간
        if (1 < landCount()) {
            break
        }
    }
    println(year)
}

private fun melting(): Boolean {
    val visited = Array(map.size) {BooleanArray(map[0].size)}
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] != 0 && !visited[i][j]) {
                for (k in 0 until 4) {
                    val dx = i + dx[k]
                    val dy = j + dy[k]
                    if (map[dx][dy] == 0 && !visited[dx][dy]) {
                        if (0 < map[i][j]) {
                            map[i][j]--
                            visited[i][j] = true
                        }
                    }
                }
            }
        }
    }
    var check = false
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] != 0) {
                check = true
                break
            }
        }
    }
    return check
}

private fun landCount(): Int {
    val visited = Array(map.size) {BooleanArray(map[0].size)}
    var ice = 0
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] != 0 && !visited[i][j]) {
                val queue: Queue<Pair<Int, Int>> = LinkedList()
                queue.offer(Pair(i, j))
                visited[i][j] = true
                // bfs 를 통한 하나의 빙산이 추가
                ice++
                while (queue.isNotEmpty()) {
                    val curr = queue.poll()
                    for (k in 0 until 4) {
                        val dx = curr.first + dx[k]
                        val dy = curr.second + dy[k]
                        if (map[dx][dy] != 0 && !visited[dx][dy]) {
                            visited[dx][dy] = true
                            queue.offer(Pair(dx, dy))
                        }
                    }
                }
            }
        }
    }
    return ice
}
