package boj.최단거리

private lateinit var graph: Array<CharArray>
private lateinit var dist: Array<IntArray>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n) { CharArray(m) }
    dist = Array(n) { IntArray(m) { 987654321 } }
    val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
    for (i in 0 until n) {
        val input = readLine().toCharArray()
        for (j in input.indices) {
            graph[i][j] = input[j]
        }
    }
    val deque = ArrayDeque<Triple<Int, Int, Int>>()
    deque.addFirst(Triple(x1 - 1, y1 - 1, 0))
    while (deque.isNotEmpty()) {
        val (x, y, weight) = deque.removeFirst()
        // 현재 가중치가 이미 거리배열의 값보다 클때
        if (dist[x][y] < weight) continue
        for (i in 0 until 4) {
            val dx = x + dx[i]
            val dy = y + dy[i]
            if (dx in 0 until n && dy in 0 until m) {
                if (graph[dx][dy] == '1') {
                    if (weight + 1 < dist[dx][dy]) {
                        dist[dx][dy] = weight + 1
                        deque.addLast(Triple(dx, dy, weight + 1 ))
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
    println(dist[x2 - 1][y2 - 1] + 1)
}
