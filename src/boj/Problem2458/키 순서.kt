package boj.Problem2458

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(n) }
    var answer = 0
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        arr[a - 1][b - 1] = 1
    }
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (arr[i][k] == 1 && arr[k][j] == 1) {
                    arr[i][j] = 1
                }
            }
        }
    }
    for (i in 0 until n) {
        var count = 0
        for (j in 0 until n) {
            if (arr[i][j] == 1 || arr[j][i] == 1) count++
        }
        if (count == n - 1) answer++
    }
    println(answer)
}