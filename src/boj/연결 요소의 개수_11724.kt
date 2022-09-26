package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var visited: BooleanArray
private lateinit var graph: Array<LinkedList<Int>>
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(' ').map { it.toInt() }
    visited = BooleanArray(input[0])
    var count = 0
    graph = Array(input[0]) { LinkedList<Int>() }
    for (i in 0 until input[1]) {
        val relation = readLine().split(' ').map { it.toInt() }
        graph[relation[0] - 1].add(relation[1] - 1)
        graph[relation[1] - 1].add(relation[0] - 1)
    }
    // 인접리스트 탐색
    for (j in graph.indices) {
        if (!visited[j]) {
            dfs(j)
            count++
        }
    }
    println(count)
}

private fun dfs(start: Int) {
    visited[start] = true
    for (adjNode in graph[start]) {
        if (!visited[adjNode]) {
            dfs(adjNode)
        }
    }
}
