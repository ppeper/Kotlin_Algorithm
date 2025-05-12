package boj.Problem3184

private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)
private lateinit var graph: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private var sheep = 0
private var wolf = 0
private val answer = IntArray(2)
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n) { readLine().toCharArray() }
    visited = Array(n) { BooleanArray(m) }
    for (i in graph.indices) {
        for (j in graph[0].indices) {
            if (visited[i][j]) continue
            if (graph[i][j] == '#') continue
            sheep = 0
            wolf = 0
            dfs(i, j)
            if (wolf < sheep) {
                answer[0] += sheep
            } else {
                answer[1] += wolf
            }
        }
    }
    println("${answer[0]} ${answer[1]}")
}

private fun dfs(i: Int, j: Int) {
    visited[i][j] = true
    if (graph[i][j] == 'v') wolf++
    else if (graph[i][j] == 'o') sheep++
    for (d in 0 until 4) {
        val nx = i + dx[d]
        val ny = j + dy[d]
        if (nx !in graph.indices || ny !in graph[0].indices) continue
        if (visited[nx][ny]) continue
        if (graph[nx][ny] == '#') continue
        dfs(nx, ny)
    }
}
