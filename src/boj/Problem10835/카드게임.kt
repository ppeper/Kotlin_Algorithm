package boj.Problem10835

private lateinit var dp: Array<IntArray>
private lateinit var leftCards: List<Int>
private lateinit var rightCards: List<Int>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dp = Array(n) { IntArray(n * 2) { -1 } }
    leftCards = readLine().split(" ").map { it.toInt() }
    rightCards = readLine().split(" ").map { it.toInt() }
    println(search(0, 0))
}

private fun search(left: Int, right: Int): Int {
    if (left == leftCards.size || right == rightCards.size) return 0
    if (dp[left][right] != -1) return dp[left][right]
    val leftCard = leftCards[left]
    val rightCard = rightCards[right]
    if (rightCard < leftCard) {
        dp[left][right] = dp[left][right]
            .coerceAtLeast(search(left, right + 1) + rightCard)
    } else {
        dp[left][right] = dp[left][right]
            .coerceAtLeast(search(left + 1, right + 1))
            .coerceAtLeast(search(left + 1, right))
    }
    return dp[left][right]
}
