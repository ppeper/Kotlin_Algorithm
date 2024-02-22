package boj.Problem14728

import kotlin.math.max

private lateinit var dp: Array<IntArray>
private lateinit var list: Array<List<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, t) = readLine().split(" ").map { it.toInt() }
    list = Array(n) { readLine().split(" ").map { it.toInt() }}
    dp = Array(n + 1) { IntArray(t + 1) { -1 } }
    println(search(t, 0))
}

private fun search(total: Int, n: Int): Int {
    if (n == list.size) return 0
    if (dp[n][total] != -1) return dp[n][total]
    val (time, credit) = list[n]
    if (time <= total) {
        dp[n][total] = max(search(total, n + 1), search(total - time, n + 1) + credit)
    } else {
        dp[n][total] = search(total, n + 1)
    }
    return dp[n][total]
}
