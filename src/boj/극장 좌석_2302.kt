package boj

fun main() {
    val size = readln().toInt()
    val dp = IntArray(size + 1) { 0 }
    for (i in dp.indices) {
        when (i) {
            0 -> dp[i] = 1
            1 -> dp[i] = 1
            2 -> dp[i] = 2
            else -> dp[i] = dp[i - 1] + dp[i - 2]
        }
    }
    val fixed = readln().toInt()
    var prev = 0
    var answer = 1
    for (j in 0 until fixed) {
        val vip = readln().toInt()
        answer *= dp[vip - prev - 1]
        prev = vip
    }
    // 마지막 vip부터 끝까지
    answer *= dp[size - prev]
    println(answer)
}