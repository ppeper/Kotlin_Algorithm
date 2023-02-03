package boj

private lateinit var list: List<Int>
private val answer1 = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    list = readLine().split(" ").map { it.toInt() }.distinct().sorted()
    backtracking12(0, M, "")
    println(answer1)
}

private fun backtracking12(start: Int, m: Int, result: String) {
    if (m == 0) {
        answer1.append(result).append("\n")
        return
    }
    for (i in start until list.size) {
        backtracking12(i, m - 1, result + "${list[i]} ")
    }
}
