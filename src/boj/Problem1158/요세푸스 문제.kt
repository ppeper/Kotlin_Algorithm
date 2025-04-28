package boj.Problem1158

fun main() = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<Int>()
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val list = (1..n).toMutableList()
    var index = 0
    repeat(n) {
        index = (index + k - 1) % list.size
        list.removeAt(index).also {
            answer.add(it)
        }
    }
    println(answer.joinToString(", ", "<", ">"))
}