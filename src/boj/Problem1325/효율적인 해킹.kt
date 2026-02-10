package boj.Problem1325

import java.util.LinkedList
import java.util.ArrayList

private lateinit var graph: Array<ArrayList<Int>>
private lateinit var visited: BooleanArray
private lateinit var count: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)
    count = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[b].add(a)
    }
    for (node in 1..n) {
        bfs(node)
    }
    println(count.withIndex()
        .filter { it.value == count.maxOrNull() }
        .map { it.index }
        .joinToString(" ")
    )
}

private fun bfs(node: Int) {
    val queue = LinkedList<Int>()
    visited.fill(false)
    queue.add(node)
    visited[node] = true
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        for (nextNode in graph[curr]) {
            if (visited[nextNode]) continue
            visited[nextNode] = true
            count[node] += 1
            queue.add(nextNode)
        }
    }
}
