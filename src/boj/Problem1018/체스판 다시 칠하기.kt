package boj.Problem1018

private var answer = Int.MAX_VALUE
private lateinit var chess: Array<String>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    chess = Array(n) { readLine() }
    for (i in 0..n - 8) {
        for (j in 0..m - 8) {
            answer = answer.coerceAtMost(getMinCount(i, j))
        }
    }
    println(answer)
}

private fun getMinCount(i: Int, j: Int): Int {
    var count1 = 0
    var count2 = 0
    for (x in i until i + 8) {
        for (y in j until j + 8) {
            // 짝수 idx -> 횐색이라 가정
            if ((x + y) % 2 == 0) {
                when (chess[x][y]) {
                    'B' -> count1++
                    else -> count2++
                }
            } else {
                when (chess[x][y]) {
                    'W' -> count1++
                    else -> count2++
                }
            }
        }
    }
    return count1.coerceAtMost(count2)
}
