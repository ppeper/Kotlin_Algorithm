package boj.Problem1806

fun main() = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().split(" ").map { it.toInt() }
    val list = IntArray(n + 1)
    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, value ->
        list[index + 1] = list[index] + value
    }
    var answer = Int.MAX_VALUE
    var start = 0
    var end = 0
    while (end in start..n) {
        if (s <= list[end] - list[start]) {
            answer = answer.coerceAtMost(end - start)
            start += 1
        } else {
            end += 1
        }
    }
    if (answer == Int.MAX_VALUE) println(0) else println(answer)
}