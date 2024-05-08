package boj.Problem17090

private var answer = 0
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(-0, 1, 0, -1)
private lateinit var maze: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var dp: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    maze = Array(n) { readLine().toCharArray() }
    visited =  Array(n) { BooleanArray(m) }
    dp = Array(n) { IntArray(m) { -1 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            answer += if (dp[i][j] != -1) dp[i][j]
            else {
                dfs(i, j)
            }
        }
    }
    println(answer)
}

private fun dfs(i: Int, j: Int): Int {
    val dir = maze[i][j].toMoveDir()
    val nx = i + dx[dir]
    val ny = j + dy[dir]

    if (nx !in maze.indices || ny !in maze[0].indices) {
        dp[i][j] = 1
        return dp[i][j]
    }
    if (dp[nx][ny] != -1) return dp[nx][ny]
    if (visited[i][j]) return 0
    // 기존에 가본 경로가 있다면 반환
    visited[i][j] = true
    dp[i][j] = dfs(nx, ny)
    return dp[i][j]
}

private fun Char.toMoveDir(): Int {
    return when (this) {
        'U' -> 0
        'R' -> 1
        'D' -> 2
        'L' -> 3
        else -> -1
    }
}