package boj

fun main() {
    val (N, M) = readLine()!!.split(' ').map { it.toInt() }
    val list = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        list[i] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    }
    val sum = Array(N + 1) { IntArray(N + 1) }
    for (i in 0 until N) {
        for (j in 0 until N) {
            sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + list[i][j]
        }
    }
    val answer = mutableListOf<Int>().apply {
        repeat(M) {
            val (x1, y1, x2, y2) = readLine()!!.split(' ').map { it.toInt() }
            add(getRangeSum(x1, y1, x2, y2, sum))
        }
    }
    answer.forEach {
        println(it)
    }

}

private fun getRangeSum(x1: Int, y1: Int, x2: Int, y2: Int, sum: Array<IntArray>): Int {
    return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]
}
