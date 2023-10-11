package boj.`과거 문제들 정리`

private lateinit var list: List<Int>
private val answer1 = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    list = readLine().split(" ").map { it.toInt() }.distinct().sorted()
    backtracking11(M, "")
    println(answer1)
}

private fun backtracking11(m: Int, result: String) {
    if (m == 0) {
        answer1.append(result).append("\n")
        return
    }
    for (i in list.indices) {
        backtracking11(m - 1, result + "${list[i]} ")
    }
}
