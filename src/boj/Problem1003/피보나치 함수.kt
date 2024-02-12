package boj.Problem1003

private lateinit var dp: IntArray
private var sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    dp = IntArray(41)
    dp[1] = 1
    for (n in 2..40) {
        dp[n] = dp[n - 2] + dp[n - 1]
    }
    repeat(t) {
        val num = readLine().toInt()
        if (num == 0) {
            sb.append("1 0\n")
        } else {
            sb.append("${dp[num - 1]} ${dp[num]}\n")
        }
    }
    println(sb)
}