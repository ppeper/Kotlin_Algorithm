package boj.Problem1463

private lateinit var dp: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dp = IntArray(n + 1) { -1 }
    println(search(n))
}

private fun search(n: Int): Int {
    if (n == 1) return 0
    if (dp[n] != -1) return dp[n]

    dp[n] = search(n - 1) + 1
    if (n % 3 == 0) {
        val value = search(n / 3) + 1
        if (value < dp[n]) {
            dp[n] = value
        }
    }
    if (n % 2 == 0) {
        val value = search(n / 2) + 1
        if (value < dp[n]) {
            dp[n] = value
        }
    }
    return dp[n]
}
