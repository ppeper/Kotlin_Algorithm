package boj

fun main() {
    val firstWord = mutableListOf<Char>().apply {
        readLine()!!.forEach { add(it) }
    }
    val secondWord = mutableListOf<Char>().apply {
        readLine()!!.forEach { add(it) }
    }
    val dp = Array(firstWord.size + 1) { IntArray(secondWord.size + 1) { 0 } }
    for (i in dp.indices) {
        for (j in dp[0].indices) {
            if (i == 0 || j == 0) {
                dp[i][j] = 0
            } else if (firstWord[i - 1] == secondWord[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            }
        }
    }
    var count = 0
    for (i in dp.indices) {
        for (j in dp[0].indices) {
            count = count.coerceAtLeast(dp[i][j])
        }
    }
    println(count)
}