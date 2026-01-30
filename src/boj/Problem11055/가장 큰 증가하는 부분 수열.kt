package boj.Problem11055

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n)
    for (i in list.indices) {
        dp[i] = list[i]
        for (j in 0 until i) {
            if (list[j] < list[i]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + list[i])
            }
        }
    }
    println(dp.max())
}