package boj.Problem6603

private lateinit var pick: IntArray
private lateinit var numbers: List<Int>
private var answer = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    pick = IntArray(6)
    while (true) {
        val input = readLine().split(" ").map { it.toInt() }
        if (input[0] == 0) break
        numbers = input.slice(1 until input.size)
        permutation(0, 0)
        answer.append("\n")
    }
    println(answer)
}

private fun permutation(start: Int, depth: Int) {
    if (depth == 6) {
        answer.append(pick.joinToString(" ")).append("\n")
        return
    }
    for (i in start until numbers.size) {
        pick[depth] = numbers[i]
        permutation(i + 1, depth + 1)
    }
}
