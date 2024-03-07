package boj.Problem22945

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    var answer = 0
    var start = 0
    var end = n - 1
    var between = n - 2
    while (start < end) {
        answer = answer.coerceAtLeast(between * min(list[start], list[end]))
        // 더 작은 수쪽을 앞으로 옮김
        if (list[start] < list[end]) start++
        else end--
        between--
    }
    println(answer)
}