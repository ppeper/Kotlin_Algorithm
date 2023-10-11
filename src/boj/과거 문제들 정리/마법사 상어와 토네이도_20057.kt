package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader

// 좌하우상
private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)
private val scatterX = arrayOf(
    intArrayOf(-1, 1, -1, 1, -2, 2, -1, 1, 0),
    intArrayOf(-1, -1, 0, 0, 0, 0, 1, 1, 2),
    intArrayOf(-1, 1, -1, 1, -2, 2, -1, 1, 0),
    intArrayOf(1, 1, 0, 0, 0, 0, -1, -1, -2)
)
private val scatterY = arrayOf(
    intArrayOf(1, 1, 0, 0, 0, 0, -1, -1, -2),
    intArrayOf(-1, 1, 1, -1, 2, -2, -1, 1, 0),
    intArrayOf(-1, -1, 0, 0, 0, 0, 1, 1, 2),
    intArrayOf(-1, 1, -1, 1, -2, 2, 1, -1, 0)
)
private val amount = intArrayOf(1, 1, 7, 7, 2, 2, 10, 10, 5)
private lateinit var board: Array<IntArray>
private var overSand = 0
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    board = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        val input = readLine().split(' ').map { it.toInt() }
        board[i] = input.toIntArray()
    }
    tornado(N)
    println(overSand)
}

private fun tornado(N: Int) {
    // 시작점
    var cx = N / 2
    var cy = N / 2
    // 처음 방향 -> 좌측
    var dir = 0
    // 가야할 크기
    var move = 1
    // 현재 간 크기
    var count = 0
    var check = 0
    while (true) {
        if (cx == 0 && cy == 0) {
            break
        }
        // 이동한 좌표
        val nx = cx + dx[dir]
        val ny = cy + dy[dir]
        // 모래 이동
        board[nx][ny] += board[cx][cy]
        board[cx][cy] = 0
        count++
        scatterSand(nx, ny, dir)
        // move 만큼 이동하며 방향 전환
        if (count == move) {
            count = 0
            check++
            dir = (dir + 1) % 4
        }
        // 두번 이동 완료
        if (check == 2) {
            check = 0
            move++
        }
        cx = nx
        cy = ny
    }
}

private fun scatterSand(nx: Int, ny: Int, dir: Int) {
    val sandAmount = board[nx][ny]
    var remain = sandAmount
    // 알파 위치
    val ax = nx + dx[dir]
    val ay = ny + dy[dir]
    for (i in 0 until 9) {
        val x = nx + scatterX[dir][i]
        val y = ny + scatterY[dir][i]
        val s = sandAmount * amount[i] / 100
        isValid(x, y, s)
        // 남은 모래양
        remain -= s
    }
    // 마지막 알파 자리 모래
    isValid(ax, ay, remain)
    board[nx][ny] = 0
}

private fun isValid(x: Int, y: Int, sand: Int) {
    // 범위 안에 있으면 모래 추가
    if (x in board.indices && y in board.indices) {
        board[x][y] += sand
    } else {
        overSand += sand
    }
}
