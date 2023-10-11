package boj.`과거 문제들 정리`

fun main() {
    val (N, M, B) = readLine()!!.split(' ').map { it.toInt() }
    val board = Array(N) { IntArray(M) }
    for (i in 0 until N) {
        board[i] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    }
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (i in 0 until N) {
        for (j in 0 until M) {
            min = board[i][j].coerceAtMost(min)
            max = board[i][j].coerceAtLeast(max)
        }
    }
    var minTime = Int.MAX_VALUE
    var height = 0
    // 최소시간 구하기
    for (h in min..max) {
        var invent = B
        var time = 0
        for (i in board.indices) {
            for (j in board[i].indices) {
                // 높이보다 작을때
                if (board[i][j] < h) {
                    time += (h - board[i][j])
                    invent -= (h - board[i][j])
                } else if (h < board[i][j]) {
                    time += 2 * (board[i][j] - h)
                    invent += (board[i][j] - h)
                }
            }
        }
        // 평탄화를 할 수 있는 경우
        if (invent >= 0 && time <= minTime) {
            minTime = time
            height = h
        }
    }
    println("$minTime $height")
}