package boj.`과거 문제들 정리`

fun main() {
    val (N, M) = readLine()!!.split(' ').map { it.toInt() }
    val list = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        list[i] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    }
    val sum = Array(N + 1) { IntArray(M + 1) }
    // 누적합 구하기
    for (i in list.indices) {
        for (j in list[i].indices) {
            sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + list[i][j]
        }
    }
    val count = readln().toInt()
    val answer = IntArray(count)
    for (j in 0 until count) {
        val (x1, y1, x2, y2) = readLine()!!.split(' ').map { it.toInt() }
        answer[j] = getSum(x1, y1, x2, y2, sum)
    }
    answer.forEach {
        println(it)
    }
}

private fun getSum(x1: Int, y1: Int, x2: Int, y2: Int, sum: Array<IntArray>): Int {
    return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]
}
