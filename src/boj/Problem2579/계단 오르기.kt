package boj.Problem2579

private lateinit var list: IntArray
private lateinit var dp: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    list = IntArray(n) { readLine().toInt() }
    dp = Array(3) { IntArray(n) { -1 } }
    println(search(n - 1, 1))
}

private fun search(n: Int, step: Int): Int {
    if (n < 0) return 0
    if (dp[step][n] != -1) return dp[step][n]
    dp[step][n] = dp[step][n].coerceAtLeast(search(n - 2, 1) + list[n])
    if (step < 2) {
        dp[step][n] = dp[step][n].coerceAtLeast(search(n - 1, step + 1) + list[n])
    }
    return dp[step][n]
}