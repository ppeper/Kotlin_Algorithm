package boj.Problem4485

import java.util.PriorityQueue

private const val INF = 987654321
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var map: Array<IntArray>
private lateinit var dist: Array<IntArray>
private var n = 0
fun main() = with(System.`in`.bufferedReader()) {
    var number = 1
    while (true) {
        n = readLine().toInt()
        if (n == 0) break
        map = Array(n) { IntArray(n) }
        dist = Array(n) { IntArray(n) { INF } }
        for (i in 0 until n) {
            map[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        dist[0][0] = map[0][0]
        dijkstra()
        println("Problem $number: ${dist[n - 1][n - 1]}")
        number++
    }
}

private fun dijkstra() {
    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
    pq.offer(Triple(0, 0, map[0][0]))
    while(pq.isNotEmpty()) {
        val (from, to, cost) = pq.poll()
        for (i in 0 until 4) {
            val nx = from + dx[i]
            val ny = to + dy[i]
            if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue
            if (dist[nx][ny] <  map[nx][ny]) continue
            if (dist[from][to] + map[nx][ny] < dist[nx][ny]) {
                dist[nx][ny] = dist[from][to] + map[nx][ny]
                pq.offer(Triple(nx, ny, dist[nx][ny]))
            }
        }
    }
}

