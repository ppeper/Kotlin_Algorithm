package boj.Problem15649


private lateinit var pick: IntArray
private lateinit var visited: BooleanArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    pick = IntArray(m)
    visited = BooleanArray(n)
    permutation(0, n, m)
}

private fun permutation(idx: Int, n: Int, r: Int) {
    if (idx == r) {
        println(pick.joinToString(" "))
        return
    }
    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            pick[idx] = i + 1
            permutation(idx + 1, n, r)
            visited[i] = false
        }
    }
}
