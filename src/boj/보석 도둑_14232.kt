package boj

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    var K = readLine().toLong()
    var count = 0
    var devide = 2L
    val answer = StringBuilder()
    while (K != 1L) {
        if (1000000 <= devide) {
            count++
            answer.append("$K ")
            break
        }
        // 나누어 떨어짐
        if (K % devide == 0L) {
            K /= devide
            answer.append("$devide ")
            count++
        } else {
            devide++
        }
    }
    println(count)
    println(answer)
}