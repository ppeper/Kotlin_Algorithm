package boj.`과거 문제들 정리`

import kotlin.math.max

fun main() {
    val case = readln().toInt()
    val answer = Array(case) { 0 }
    repeat(case) {
        val size = readln().toInt()
        val sticker = Array(2) { IntArray(size) }
        val dp = Array(2) { IntArray(size) }
        for (i in 0 until 2) {
            sticker[i] = readln().split(' ').map { it.toInt() }.toIntArray()
        }
        // 스티커의 최대의 점수 출력
        for (j in sticker[0].indices) {
            when (j) {
                0 ->  {
                    dp[0][j] = sticker[0][j]
                    dp[1][j] = sticker[1][j]
                }
                1 -> {
                    dp[0][j] = sticker[0][1] + sticker[1][0]
                    dp[1][j] = sticker[1][1] + sticker[0][0]
                }
                else -> {
                    dp[0][j] = max(dp[0][j - 2] + sticker[0][j], max(dp[1][j - 1] + sticker[0][j], dp[1][j - 2] + sticker[0][j]))
                    dp[1][j] = max(dp[1][j - 2] + sticker[1][j], max(dp[0][j - 1] + sticker[1][j], dp[0][j - 2] + sticker[1][j]))
                }
            }
        }
        answer[it] = max(dp[0][size - 1], dp[1][size - 1])
    }
    answer.forEach {
        println(it)
    }
}