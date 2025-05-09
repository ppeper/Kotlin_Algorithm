package boj.Problem14620

private var answer = Int.MAX_VALUE
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var graph: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    graph = Array(n) { IntArray(n) }
    visited = Array(n) { BooleanArray(n) }
    repeat(n) {
        graph[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    backtracking(0, 0)
    println(answer)
}

private fun backtracking( sum: Int, count: Int) {
    if (count == 3) {
        answer = answer.coerceAtMost(sum)
        return
    }
    for (i in 1 until graph.size - 1) {
        for (j in 1 until graph[0].size - 1) {
            if (isAvailable(i, j)) {
                setBoolean(i, j, true)
                backtracking(sum + flowerSum(i, j), count + 1)
                setBoolean(i, j, false)
            }
        }
    }
}

private fun isAvailable(x: Int, y: Int): Boolean {
    if (visited[x][y]) return false
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (visited[nx][ny]) return false
    }
    return true
}

private fun flowerSum(x: Int, y: Int): Int {
    var sum = graph[x][y]
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        sum += graph[nx][ny]
    }
    return sum
}

private fun setBoolean(x: Int, y: Int, value: Boolean) {
    visited[x][y] = value
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        visited[nx][ny] = value
    }
}