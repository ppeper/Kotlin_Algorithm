package boj.Problem2533

import java.util.*
import kotlin.math.min

private lateinit var tree: Array<LinkedList<Int>>
private lateinit var visited: BooleanArray
private lateinit var dp: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = Array(n + 1) { LinkedList() }
    dp = Array(2) { IntArray(n + 1) }
    visited = BooleanArray(n + 1)
    repeat(n - 1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }
    dfs(1)
    println(min(dp[0][1], dp[1][1]))
}

private fun dfs(start: Int) {
    visited[start] = true
    dp[1][start] = 1
    for (next in tree[start]) {
        if (visited[next]) continue
        // 얼리어답터 확인
        dfs(next)
        dp[0][start] += dp[1][next]
        dp[1][start] += min(dp[0][next], dp[1][next])
    }
}