package boj.Problem11404

private const val INF = 987654321
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val dist = Array(n + 1) { IntArray(n + 1) { INF } }
    for (i in 1..n) {
        dist[i][i] = 0
    }
    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        if (c < dist[a][b]) dist[a][b] = c
    }
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }
    for (i in 1..n) {
        for (j in 1..n) {
            if (dist[i][j] == INF) print("0 ") else print("${dist[i][j]} ")
        }
        println()
    }
}