package boj

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var board: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var dp: Array<IntArray>
fun main() {
    val (M, N) = readLine()!!.split(' ').map { it.toInt() }
    board = Array(M) { IntArray(N) }
    for (i in 0 until M) {
        board[i] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    }
    visited = Array(M) { BooleanArray(N) }
    dp = Array(M) { IntArray(N) { 0 } }
    println(moveToLowPoint(M - 1, N - 1))
}

private fun moveToLowPoint(x: Int, y: Int): Int {
    // 시작점으로 도착 -> 해당 경로 가능
    if (x == 0 && y == 0) {
        return 1
    }
    if (!visited[x][y]) {
        visited[x][y] = true
        // 갈 수 있는 방향 확인
        for (i in 0 until 4) {
            val cx = x + dx[i]
            val cy = y + dy[i]
            if (isValid(cx, cy)) {
                // 내리막길 확인
                if (board[x][y] < board[cx][cy]) {
                    dp[x][y] += moveToLowPoint(cx, cy)
                }
            }
        }
    }
    return dp[x][y]
}

private fun isValid(x: Int, y: Int): Boolean {
    return x in board.indices && y in board[0].indices
}
