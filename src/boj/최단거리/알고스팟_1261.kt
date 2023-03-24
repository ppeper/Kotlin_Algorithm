package boj.최단거리

private lateinit var graph: Array<IntArray>
private lateinit var dist: Array<IntArray>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(m) { IntArray(n) }
    dist = Array(m) { IntArray(n) { 987654321 } }
    for (i in 0 until m) {
        val input = readLine().toCharArray()
        for (j in input.indices) {
            graph[i][j] = input[j] - '0'
        }
    }
    dist[0][0] = 0
    val deque = ArrayDeque<Triple<Int, Int, Int>>()
    deque.addFirst(Triple(0, 0, 0))
    checkMap(deque)
    println(dist[m - 1][n - 1])
}

private fun checkMap(deque: ArrayDeque<Triple<Int, Int, Int>>) {
    while (deque.isNotEmpty()) {
        val (x, y, weight) = deque.removeFirst()
        if (dist[x][y] < weight) continue
        for (i in 0 until 4) {
            val dx = x + dx[i]
            val dy = y + dy[i]
            if (dx in graph.indices && dy in graph[0].indices) {
                if (graph[dx][dy] == 1) {
                    if (weight + 1 < dist[dx][dy]) {
                        dist[dx][dy] = weight + 1
                        deque.addLast(Triple(dx, dy, weight + 1))
                    }
                } else {
                    if (weight < dist[dx][dy]) {
                        dist[dx][dy] = weight
                        deque.addFirst(Triple(dx, dy, weight))
                    }
                }
            }
        }
    }
}
