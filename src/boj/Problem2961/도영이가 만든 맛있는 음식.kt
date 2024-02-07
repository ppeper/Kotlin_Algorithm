package boj.Problem2961

import kotlin.math.abs

private lateinit var list: Array<List<Int>>
private var answer = Int.MAX_VALUE
private var N = 0
fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    list = Array(N) { readLine().split(" ").map { it.toInt() } }
    pickGradient(list[0][0], list[0][1], 1)
    pickGradient(1, 0, 1)
    println(answer)
}

private fun pickGradient(sum1: Int, sum2: Int, pick: Int) {
    if (pick == N) {
        if (sum1 == 1 && sum2 == 0) return
        answer = answer.coerceAtMost(abs(sum1 - sum2))
        return
    }
    pickGradient(sum1 * list[pick][0], sum2 + list[pick][1], pick + 1)
    pickGradient(sum1, sum2, pick + 1)
}
