package boj.Problem1987

private lateinit var board: Array<CharArray>
private lateinit var visited: BooleanArray
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private var answer = 1
fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    board = Array(r) { readLine().toCharArray() }
    visited = BooleanArray(26).apply {
        this[board[0][0] - 'A'] = true
    }
    dfs(0, 0, 1)
    println(answer)
}

private fun dfs(x: Int, y: Int, count: Int) {
    answer = answer.coerceAtLeast(count)
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx !in board.indices || ny !in board[0].indices) continue
        if (visited[board[nx][ny] - 'A']) continue
        visited[board[nx][ny] - 'A'] = true
        dfs(nx, ny, count + 1)
        visited[board[nx][ny] - 'A'] = false
    }
}
