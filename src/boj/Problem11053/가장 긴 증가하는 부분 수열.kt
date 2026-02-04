package boj.Problem11053

private lateinit var numbers: List<Int>
private lateinit var dp: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dp = IntArray(n)
    numbers = readLine().split(" ").map { it.toInt() }
    for (i in numbers.indices) {
        dp[i] = 1
        for (j in 0 until i) {
            if (numbers[j] < numbers[i]) {
                dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
            }
        }
    }
    println(dp.max())
}