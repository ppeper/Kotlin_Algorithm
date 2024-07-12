package boj.Problem10971

private lateinit var graph: Array<List<Int>>
private lateinit var visited: BooleanArray
private var answer = Int.MAX_VALUE
private var N = 0
fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    graph = Array(N) { readLine().split(" ").map { it.toInt() }}
    visited = BooleanArray(N)
    for (i in 0 until N) {
        search(i, i, 0, 0)
    }
    println(answer)

}

private fun search(start: Int, from: Int, cost: Int, travel: Int) {
    // 한번 순회 완료
    if (start == from && travel == N) {
        answer = answer.coerceAtMost(cost)
        return
    }
    for (to in 0 until N) {
        if (graph[from][to] == 0) continue
        if (visited[to]) continue
        visited[to] = true
        search(start, to, cost + graph[from][to], travel + 1)
        visited[to] = false
    }
}
