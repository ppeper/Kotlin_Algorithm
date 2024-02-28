package boj.Problem11437

import java.util.*

private lateinit var tree: Array<LinkedList<Int>>
private lateinit var parent: IntArray
private lateinit var depth: IntArray
private var answer = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    tree = Array(n + 1) { LinkedList() }
    parent = IntArray(n + 1)
    depth = IntArray(n + 1)
    repeat(n - 1) {
        val (to, from) = readLine().split(" ").map { it.toInt() }
        tree[from].add(to)
        tree[to].add(from)
    }
    dfs(1, 0, 0)
    val m = readLine().toInt()
    repeat(m) {
        val (from, to) = readLine().split(" ").map { it.toInt() }
        answer.append("${lca(from, to)}\n")
    }
    println(answer)
}

private fun lca(from: Int, to: Int): Int {
    var node1 = from
    var node2 = to

    while (depth[node1] != depth[node2]) {
        if (depth[node1] < depth[node2]) {
            node2 = parent[node2]
        } else {
            node1 = parent[node1]
        }
    }

    while (node1 != node2) {
        node1 = parent[node1]
        node2 = parent[node2]
    }
    return node1
}

private fun dfs(curr: Int, p: Int, d: Int) {
    parent[curr] = p
    depth[curr] = d

    for (next in tree[curr]) {
        if (next == p) continue
        dfs(next, curr, d + 1)
    }
}
