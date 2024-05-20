package boj.Problem11726

private lateinit var dp: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dp = IntArray(n + 1) { -1 }
    println(search(n))
}

private fun search(n: Int): Int {
    if (n == 0 || n == 1) return 1
    if (dp[n] != -1) return dp[n]
    dp[n] = search(n - 2) + search(n - 1)
    dp[n] %= 10007
    return dp[n]
}
