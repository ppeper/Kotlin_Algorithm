package boj.최단거리


private const val INF = 10
fun main() = with(System.`in`.bufferedReader()) {

    fun floyd(dist: Array<IntArray>, n: Int) {
        // k -> 거쳐 가는 노드
        for (k in 0 until n) {
            // i -> 출발 노드
            for (i in 0 until n) {
                // j -> 도착 노드
                for (j in 0 until n) {
                    dist[i][j] = dist[i][j].coerceAtMost(dist[i][k] + dist[k][j])
                }
            }
        }
    }

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dist = Array(n) { IntArray(n) { INF } }
    for (i in 0 until n) {
        dist[i][i] = 0
    }
    for (i in 0 until m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        dist[a - 1][b - 1] = 1
        dist[b - 1][a - 1] = 1
    }
    floyd(dist, n)
    var isAvailable = true
    for (array in dist) {
        if (array.any { 6 < it }) {
            isAvailable = false
        }
    }
    if (isAvailable) println("Small World!") else println("Big World!")
}