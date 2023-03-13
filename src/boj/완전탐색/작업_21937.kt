package boj.완전탐색

import java.util.LinkedList

private lateinit var visited: BooleanArray
private lateinit var graph: Array<LinkedList<Int>>
private var count = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { LinkedList<Int>() }
    visited = BooleanArray(n + 1)
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[b].add(a)
    }
    val target = readLine().toInt()
    dfs(target)
    println(count)
}

private fun dfs(target: Int) {
    visited[target] = true
    for (adj in graph[target]) {
        if (!visited[adj]) {
            visited[adj] = true
            count++
            dfs(adj)
        }
    }
    return
}
