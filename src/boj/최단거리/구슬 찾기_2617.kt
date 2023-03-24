package boj.최단거리

private lateinit var graph: Array<IntArray>
private var answer = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { IntArray(n + 1) }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a][b] = 1
        graph[b][a] = -1
    }
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (graph[i][k] == -1 && graph[k][j] == -1) {
                    graph[i][j] = -1
                    graph[j][i] = 1
                }
            }
        }
    }
    val less = (n - 1) / 2
    val over = n - (n + 1) / 2
    for (i in 1..n) {
        var overCount = 0
        var lessCount = 0
        for (j in 1.. n) {
            if (graph[i][j] == 1) overCount++
            if (graph[i][j] == -1) lessCount++
        }
        if (over < overCount || less < lessCount) answer++
    }
    println(answer)
}
