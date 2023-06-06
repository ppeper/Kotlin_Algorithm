package boj.Problem2230

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var answer = Int.MAX_VALUE
    val list = IntArray(n)
    repeat(n) {
        list[it] = readLine().toInt()
    }
    list.sort()
    var start = 0
    var end = 1
    while (start < n && end < n) {
        val diff = list[end] - list[start]
        if (diff == m) {
            answer = m
            break
        } else if (m < diff) {
            start++
            answer = answer.coerceAtMost(diff)
        } else {
            end++
        }
    }
    println(answer)
}
