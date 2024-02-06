package boj.Problem1759

private lateinit var pick: Array<String>
private lateinit var answer: MutableList<String>
fun main() = with(System.`in`.bufferedReader()) {
    val (l, c) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ")
    pick = Array(l) { "" }
    answer = mutableListOf()
    permutation(0, 0, l, list)
    answer.sorted().forEach {
        println(it)
    }
}

private fun checkPossible(): Boolean {
    return 1 <= pick.count { it == "a" || it == "i" || it == "e" || it == "o" || it == "u" }
            && 2 <= pick.count { it != "a" && it != "i" && it != "e" && it != "o" && it != "u" }
}

private fun permutation(start: Int, r: Int, c: Int, list: List<String>) {
    // c개를 뽑음
    if (r == c) {
        if (checkPossible()) {
            answer.add(pick.sorted().joinToString(""))
        }
        return
    }
    for (i in start until list.size) {
        pick[r] = list[i]
        permutation(i + 1, r + 1, c, list)
    }
}
