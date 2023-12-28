package boj.Problem1240

import java.util.LinkedList

data class Node(
    val to: Int,
    val length: Int
)
private lateinit var graph: Array<LinkedList<Node>>
private lateinit var visited: BooleanArray
private var sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { LinkedList() }
    repeat(n - 1) {
        val (from, to, length) = readLine().split(" ").map { it.toInt() }
        graph[from].add(Node(to, length))
        graph[to].add(Node(from, length))
    }
    // 거리를 알고 싶은 두 노드 거리
    repeat(m) {
        visited = BooleanArray(n + 1)
        val (from, to) = readLine().split(" ").map { it.toInt() }
        visited[from] = true
        dfs(from, to, 0)
    }
    println(sb)
}

private fun dfs(from: Int, to: Int, distance: Int) {
    if (from == to) {
        sb.append("$distance\n")
        return
    }
    for (adjNode in graph[from]) {
        if (visited[adjNode.to]) continue
        visited[adjNode.to] = true
        dfs(adjNode.to, to, distance + adjNode.length)
        visited[adjNode.to] = false
    }
}
