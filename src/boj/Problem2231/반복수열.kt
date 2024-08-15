package boj.Problem2231

import kotlin.math.pow

private lateinit var visited: IntArray
private var answer = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (a, p) = readLine().split(" ").map { it.toInt() }
    visited = IntArray(300000)
    dfs(a, p, 1)
    println(answer)
}

private fun dfs(value: Int, p: Int, count: Int) {
    if (visited[value] != 0) {
        answer = visited[value] - 1
        return
    }
    visited[value] = count
    val nextNum = calculateNextNumber(value, p)
    dfs(nextNum, p, count + 1)
}

private fun calculateNextNumber(value: Int, p: Int): Int {
    var curr = value
    var nextNum = 0
    while (0 < curr) {
        val pNum = curr % 10
        nextNum += pNum.toDouble().pow(p.toDouble()).toInt()
        curr /= 10
    }
    return nextNum
}
