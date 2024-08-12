package boj.Problem1389

private const val MAX = 987654321
private lateinit var distance: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    distance = Array(n) { IntArray(n) { MAX } }
    repeat(m) {
        val (from, to) = readLine().split(" ").map { it.toInt() }
        distance[from - 1][to - 1] = 1
        distance[to - 1][from - 1] = 1
    }
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                distance[i][j] = distance[i][j].coerceAtMost(distance[i][k] + distance[k][j])
            }
        }
    }
    // 가장 케빈 베이컨수가 작은 index
    val answer = distance
        .mapIndexed { index, row -> row.sum() - row[index] }
        .withIndex()
        .minBy { it.value }.index
    println(answer + 1)
}