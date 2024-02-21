package boj.Problem1472

private lateinit var map: Array<List<Int>>
private lateinit var dp: Array<Array<IntArray>>
private val dx = intArrayOf(1, 0)
private val dy = intArrayOf(0, 1)
private var N = 0
fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    dp = Array(3) { Array(N) { IntArray(N) { -1 }} }
    map = Array(N) { readLine().split(" ").map { it.toInt() }}
    println(searchTopDown(0, 0, 0))
}

private fun searchTopDown(x: Int, y: Int, toEat: Int): Int {
    if (x == N - 1 && y == N - 1) {
        return if (map[x][y] == toEat) 1 else 0
    }
    if (dp[toEat][x][y] != -1) return dp[toEat][x][y]
    val next = (toEat + 1) % 3
    for (i in 0 until 2) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in map.indices && ny in map.indices) {
            if (map[x][y] == toEat) {
                dp[toEat][x][y] = dp[toEat][x][y].coerceAtLeast(searchTopDown(nx, ny, next) + 1)
            }
            dp[toEat][x][y] = dp[toEat][x][y].coerceAtLeast(searchTopDown(nx, ny, toEat))
        }
    }
    return dp[toEat][x][y]
}
