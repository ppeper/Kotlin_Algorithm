package boj

import kotlin.math.ceil

fun main() = with(System.`in`.bufferedReader()) {
    val (A, B) = readLine().split(" ").map { it.toLong() }
    println(getMeasure(B) - getMeasure(A - 1))
}

private fun getMeasure(number: Long): Long {
    return when (number) {
        0L -> { 0 }
        1L -> { 1 }
        else -> { // 2로 나누면서 2의 거듭제곱을 확인 가능
            ceil(number.toDouble() / 2).toLong() + 2 * getMeasure(number / 2)
        }
    }
}
