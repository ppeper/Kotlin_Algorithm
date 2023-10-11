package boj.`과거 문제들 정리`

fun main() {
    val (N, K) = readLine()!!.split(' ').map { it.toInt() }
    if (K == 1) {
        println(1)
    } else {
        val dp = LongArray(N + 1) { 1 }
        for (i in 2..K) {
            for (j in 1..N) {
                dp[j] += dp[j - 1]
                dp[j] = dp[j] % 1000000000
            }
        }
        println(dp[N])
    }
}