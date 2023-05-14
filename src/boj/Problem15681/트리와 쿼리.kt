package boj.Problem15681

import java.util.*

private lateinit var tree: Array<LinkedList<Int>>
private lateinit var dp: IntArray
private lateinit var visited: BooleanArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, q) = readLine().split(" ").map { it.toInt() }
    val node = IntArray(q)
    val sb = StringBuilder()
    tree = Array(n + 1) { LinkedList() }
    visited = BooleanArray(n + 1)
    dp = IntArray(n + 1)
    repeat(n - 1) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }
    repeat(q) {
        node[it] = readLine().toInt()
    }
    dfs(r)
    node.forEach {
        sb.append("${dp[it]}\n")
    }
    println(sb)
}

private fun dfs(root: Int) {
    visited[root] = true
    dp[root] = 1
    for (child in tree[root]) {
        if (!visited[child]) {
            dfs(child)
            dp[root] += dp[child]
        }
    }
}
