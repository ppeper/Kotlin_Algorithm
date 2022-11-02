package boj

import kotlin.math.max
import kotlin.math.min

fun main() {
    val size = readln().toInt()
    val dp = Array(2) { IntArray(3) }
    for (i in 0 until size) {
        val numbers = readLine()!!.split(' ').map { it.toInt() }
        if (i == 0) {
            for (j in 0..1) {
                dp[j][0] = numbers[0]
                dp[j][1] = numbers[1]
                dp[j][2] = numbers[2]
            }
        } else {
            // 각 위치에 따라 더할 수 있는 숫자중 큰 수로 업데이트
            val maxList = dp[0].copyOf()
            val minList = dp[1].copyOf()
            // 큰수
            dp[0][0] = numbers[0] + max(maxList[0], maxList[1])
            dp[0][1] = numbers[1] + max(maxList[2] ,max(maxList[0], maxList[1]))
            dp[0][2] = numbers[2] + max(maxList[1], maxList[2])
            // 작은수
            dp[1][0] = numbers[0] + min(minList[0], minList[1])
            dp[1][1] = numbers[1] + min(minList[2] ,min(minList[0], minList[1]))
            dp[1][2] = numbers[2] + min(minList[1], minList[2])
        }
    }
    val value = getMaxAndMin(dp)
    println("${value[0]} ${value[1]}")
}

private fun getMaxAndMin(dp: Array<IntArray>): IntArray {
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    for (number in dp[0]) {
        max = max.coerceAtLeast(number)
    }
    for (number in dp[1]) {
        min = min.coerceAtMost(number)
    }
    return intArrayOf(max, min)
}