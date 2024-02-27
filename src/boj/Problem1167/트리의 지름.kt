package boj.Problem1167

import java.util.*

data class Node(
    val to: Int,
    val cost: Int
)
private lateinit var tree: Array<LinkedList<Node>>
private lateinit var visited: BooleanArray
private var maxLength = 0
private var startNode = 0
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = Array(n + 1) { LinkedList() }
    visited = BooleanArray(n + 1)
    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }
        val target = input[0]
        for (i in 1 until input.size step 2) {
            if (input[i] == -1) break
            tree[target].add(Node(input[i], input[i + 1]))
        }
    }
    dfs(1, 0)
    maxLength = 0
    visited.fill(false)
    dfs(startNode, 0)
    println(maxLength)
}

private fun dfs(start: Int, length: Int) {
    if (maxLength < length) {
        maxLength = length
        startNode = start
    }
    visited[start] = true
    for ((adjNode, cost) in tree[start]) {
        if (!visited[adjNode]) {
            visited[adjNode] = true
            dfs(adjNode, length + cost)
        }
    }
}
