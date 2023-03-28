package boj.Problem1300

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    var answer = 0
    var start = 1
    var end = k
    while (start <= end) {
        val mid = (start + end) / 2
        var count = 0
        // n개의 행 -> 최대 나보다 작은 숫자는 n개 있음
        for (i in 1..n) {
            count += min(n, mid / i)
        }
        // k와 비교
        if (count < k) {
            start = mid + 1
        } else {
            end = mid - 1
            answer = mid
        }
    }
    println(answer)
}