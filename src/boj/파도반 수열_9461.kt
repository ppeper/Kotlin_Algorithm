package boj

// 범위 생각하기 -> N이 100 -> Long 범위까지
fun main() {
    val T = readln().toInt()
    val answer = LongArray(T) { 0 }
    repeat(T) {
        val N = readln().toInt()
        val dp = LongArray(N + 1) { 0 }
        for (i in 1..N) {
            when (i) {
                in 1..3 -> {
                    dp[i] = 1
                }
                in 4..5 -> {
                    dp[i] = 2
                }
                else -> {
                    dp[i] = dp[i - 1] + dp[i - 5]
                }
            }
        }
        answer[it] = dp[N]
    }
    answer.forEach {
        println(it)
    }
}