package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: IntArray
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(' ').map { it.toInt() }
    // 범위 최대로 최기화
    map = IntArray(100001)
    search(input[0], input[1])
    println(map[input[1]])
}

private fun search(start: Int, end: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.offer(start)
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        if (curr == end) {
            break
        }
        // -1 방향
        if (0 <= curr - 1 && map[curr - 1] == 0) {
            queue.offer(curr - 1)
            map[curr - 1] = map[curr] + 1
        }
        // +1 방향
        if (curr + 1 < 100001 && map[curr + 1] == 0) {
            queue.offer(curr + 1)
            map[curr + 1] = map[curr] + 1
        }
        // 2*X 순간이동 방향
        if (2 * curr < 100001 && map[2 * curr] == 0) {
            queue.offer(2 * curr)
            map[2 * curr] = map[curr] + 1
        }
    }
}
