package boj.Problem1719

private lateinit var path: Array<IntArray>
private lateinit var board: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    path = Array(n + 1) { IntArray(n + 1) }
    board = Array(n + 1) { IntArray(n + 1) { 987654321 } }
    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        board[from][to] = cost
        board[to][from] = cost
        path[from][to] = to
        path[to][from] = from
    }
    for (i in 1..n) {
        board[i][i] = 0
    }
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (board[i][k] + board[k][j] < board[i][j]) {
                    board[i][j] = board[i][k] + board[k][j]
                    path[i][j] = path[i][k] // 가장 먼저 지나는 위치 저장
                }
            }
        }
    }
    path.drop(1).forEach { arr ->
        println(arr.drop(1).map { if (it == 0) '-' else it }.joinToString(" "))
    }
}