package boj.Problem14728

import kotlin.math.max

private lateinit var dp: Array<IntArray>
private lateinit var list: Array<List<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, t) = readLine().split(" ").map { it.toInt() }
    list = Array(n) { readLine().split(" ").map { it.toInt() }}
    dp = Array(n + 1) { IntArray(t + 1) }
    for (i in 1..n) {
        val (time, credit) = list[i - 1]
        for (j in 0..t) {
            if (j < time) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - time] + credit)
            }
        }
    }
    println(dp[n][t])
}
