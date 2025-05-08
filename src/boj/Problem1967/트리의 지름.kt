package boj.Problem1967

import java.util.LinkedList

private var answer = 0
private var leafNode = 0
private lateinit var tree: Array<LinkedList<Pair<Int, Int>>>
private lateinit var visited: BooleanArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = Array(n + 1) { LinkedList() }
    visited = BooleanArray(n + 1)
    repeat(n - 1) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        tree[a].add(b to c)
        tree[b].add(a to c)
    }
    dfs(1, 0)
    visited.fill(false)
    dfs(leafNode, 0)
    println(answer)
}

private fun dfs(start: Int, length: Int) {
    visited[start] = true
    if (answer < length) {
        leafNode = start
        answer = answer.coerceAtLeast(length)
    }
    for ((nextNode, len) in tree[start]) {
        if (visited[nextNode]) continue
        dfs(nextNode, length + len)
    }
}