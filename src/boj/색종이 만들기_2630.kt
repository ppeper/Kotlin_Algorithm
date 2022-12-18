package boj

import java.util.Scanner

private lateinit var board: Array<IntArray>
private lateinit var slice: IntArray
fun main() = with(Scanner(System.`in`)) {
    val size = nextInt()
    slice = IntArray(2) { 0 }
    board = Array(size) { IntArray(size) }
    for (i in 0 until size) {
        for (j in 0 until size) {
            board[i][j] = nextInt()
        }
    }
    sliceBoard(0, 0, size)
    println(slice[0])
    println(slice[1])
}

private fun sliceBoard(x: Int, y: Int, size: Int) {
    var check = true
    val color = board[x][y]
    for (i in x until x + size) {
        for (j in y until y + size) {
            if (color != board[i][j]) {
                check = false
                break
            }
        }
    }
    // 나눠지지 않는다
    if (check) {
        if (color == 0) slice[0]++
        if (color == 1) slice[1]++
    } else {
        val sliceSize = size / 2
        sliceBoard(x, y, sliceSize)
        sliceBoard(x + sliceSize, y, sliceSize)
        sliceBoard(x, y + sliceSize, sliceSize)
        sliceBoard(x + sliceSize, y + sliceSize, sliceSize)
    }
}
