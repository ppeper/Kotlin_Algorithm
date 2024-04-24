package boj.Problem4803

import java.util.*

private lateinit var tree: Array<LinkedList<Int>>
private lateinit var visited: BooleanArray
private lateinit var parent: IntArray
private var edgeCount = 0
private var answer = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    var i = 1
    while (true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        if (n == 0) break
        tree = Array(n + 1) { LinkedList() }
        parent = IntArray(n + 1) { it }
        visited = BooleanArray(n + 1)
        repeat(m) {
            val (from, to) = readLine().split(" ").map { it.toInt() }
            tree[from].add(to)
            tree[to].add(from)
        }
        var tree = 0
        for (node in 1..n) {
            if (visited[node]) continue
            edgeCount = 0
            var nodeCount = 0
            nodeCount += dfs(node)
            if (nodeCount - edgeCount / 2 == 1) tree++
        }
        answer.append("Case $i: ")
        when (tree) {
            0 -> answer.append("No trees.\n")
            1 -> answer.append("There is one tree.\n")
            else -> answer.append("A forest of $tree trees.\n")
        }
        i++
    }
    println(answer)
}

private fun dfs(node: Int): Int {
    var count = 1
    if (visited[node]) return 0
    visited[node] = true
    for (adjNode in tree[node]) {
        edgeCount++
        count += dfs(adjNode)
    }
    return count
}

