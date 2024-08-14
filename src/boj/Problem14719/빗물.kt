package boj.Problem14719

private lateinit var board: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    board = Array(n) { IntArray(m) }
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, height ->
        repeat(height) {
            board[n - 1 - it][index] = 1
        }
    }
    var answer = 0
    for (i in 0 until n) {
        var check = false
        var count = 0
        for (j in 0 until m) {
            if (check) {
                if (board[i][j] == 0) count++
                else {
                    answer += count
                    count = 0
                }
            } else {
                if (board[i][j] == 1) check = true
            }
        }
    }
    println(answer)
}