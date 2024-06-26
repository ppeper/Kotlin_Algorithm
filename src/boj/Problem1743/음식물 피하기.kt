package boj.Problem1743

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var board: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var answer = 1
private var count = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    board = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }
    repeat(k) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        board[x - 1][y - 1] = 1
    }
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 0) continue
            if (visited[i][j]) continue
            count = 0
            dfs(i, j)
            answer = answer.coerceAtLeast(count)
        }
    }
    println(answer)
}

private fun dfs(x: Int, y: Int) {
    visited[x][y] = true
    count++
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in board.indices || ny !in board[0].indices) continue
        if (visited[nx][ny]) continue
        if (board[nx][ny] == 0) continue
        dfs(nx, ny)
    }
}
