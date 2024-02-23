package boj.Problem13302

private const val MAX = 987654321
private lateinit var noUse: HashSet<Int>
private lateinit var dp: Array<IntArray>
private var N = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    noUse = HashSet()
    if (m != 0) {
        noUse = readLine().split(" ").map { it.toInt() }.toHashSet()
    }
    N = n
    dp = Array(n + 1) { IntArray(n + 1) { MAX } }
    println(search(1, 0))
}

private fun search(day: Int, coupon: Int): Int {
    if (N < day) return 0
    if (dp[day][coupon] != MAX) return dp[day][coupon]

    if (noUse.contains(day)) {
        dp[day][coupon] = dp[day][coupon].coerceAtMost(search(day + 1, coupon))
    } else {
        dp[day][coupon] = dp[day][coupon].coerceAtMost(search(day + 1, coupon) + 10000)
            .coerceAtMost(search(day + 3, coupon + 1) + 25000)
            .coerceAtMost(search(day + 5, coupon + 2) + 37000)
    }
    // 쿠폰 사용할 수 있을때
    if (3 <= coupon) {
        dp[day][coupon] = dp[day][coupon].coerceAtMost(search(day + 1, coupon - 3))
    }
    return dp[day][coupon]
}
