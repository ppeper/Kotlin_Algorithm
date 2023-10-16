package boj.Problem15650

private lateinit var pick: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    pick = IntArray(m)
    combination(0, 0, n,  m)
}

private fun combination(start: Int, count: Int, n: Int, r: Int) {
    if (count == r) {
        println(pick.joinToString(" "))
        return
    }
    for (i in start until n) {
        pick[count] = i + 1
        combination(i + 1, count + 1, n, r)
    }
}