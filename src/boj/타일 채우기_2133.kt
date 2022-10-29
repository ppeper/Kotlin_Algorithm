package boj

fun main() {
    val N = readln().toInt()
    val dp = IntArray(N + 1) { 0 }
    // 홀수면 타일을 채울 수 없다
    if (N % 2 == 1) {
        println(0)
    } else {
        dp[0] = 1
        // 타일 채우기 -> 1은 (2,1) (1,2)로 채울 수 없다
        for (i in 2 until dp.size step 2) {
            if (i == 2) {
                dp[i] = 3
            } else {
                dp[i] = dp[i - 2] * 3
                for (j in 4..i step 2) {
                    dp[i] += dp[i - j] * 2
                }
            }
        }
        println(dp[N])
    }
}