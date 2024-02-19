package boj.Problem1520

private lateinit var graph: Array<List<Int>>
private lateinit var dp: Array<IntArray>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var N = 0
private var M = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    dp = Array(n) { IntArray(m) { -1 } }
    graph = Array(n) { readLine().split(" ").map { it.toInt() }}
    println(checkLoad(0, 0))
}

private fun checkLoad(x: Int, y: Int): Int {
    if (x == N - 1 && y == M - 1) return 1
    if (dp[x][y] != -1) return dp[x][y]
    var temp = 0
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] < graph[x][y]) {
            temp += checkLoad(nx, ny)
        }
    }
    return temp.also { dp[x][y] = it }
}
