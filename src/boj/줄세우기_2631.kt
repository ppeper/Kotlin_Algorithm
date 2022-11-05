package boj

import kotlin.math.max

fun main() {
    val size = readln().toInt()
    val dp = IntArray(size) { 0 }
    val list = mutableListOf<Int>().apply {
        repeat(size) {
            add(readln().toInt())
        }
    }
    for (i in dp.indices) {
        dp[i] = 1
        for (j in 0 until i) {
            if (list[j] < list[i]) {
                dp[i] = max(dp[j] + 1, dp[i])
            }
        }
    }
    var maxLength = 0
    for (k in dp) {
        maxLength = k.coerceAtLeast(maxLength)
    }
    println(size - maxLength)
}