package boj.Problem14720

private lateinit var dp: IntArray
private lateinit var list: List<Int>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    list = readLine().split(" ").map { it.toInt() }
    dp = IntArray(n) { -1 }
    println(search(0, 0))
}

private fun search(start: Int, toEat: Int): Int {
    if (start == list.size) return 0
    if (dp[start] != -1) return dp[start]
    val next = (toEat + 1) % 3

    if (list[start] == toEat) {
        dp[start] = dp[start].coerceAtLeast(search(start + 1, next) + 1)
            .coerceAtLeast(search(start + 1, toEat))
    } else {
        dp[start] = dp[start].coerceAtLeast(search(start + 1, toEat))
    }
    return dp[start]
}
