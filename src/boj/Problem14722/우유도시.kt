package boj.Problem1472

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        val input = readLine().split(" ").map { it.toInt() }
        for (j in input.indices) {
            map[i][j + 1] = input[j]
        }
    }
    // 전에 먹은 우유에 대한 3차원 배열
    val dp = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        for (j in 1..n) {
            // 우유를 안먹고 오는 길중 최대
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            // 다음 먹어야할 우유라면 + 1
            if (dp[i][j] % 3 == map[i][j]) {
                dp[i][j]++
            }
        }

    }
    println(dp[n][n])
}