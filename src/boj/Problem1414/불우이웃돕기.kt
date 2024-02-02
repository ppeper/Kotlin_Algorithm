package boj.Problem1414

import java.util.PriorityQueue
import kotlin.system.exitProcess

data class Node(
    val from: Int,
    val to: Int,
    val weight: Int
): Comparable<Node> {
    override fun compareTo(other: Node) = this.weight - other.weight
}

private lateinit var parent: IntArray
private lateinit var graph: Array<IntArray>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    parent = IntArray(n + 1) { it }
    graph = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val input = readLine()
        input.forEachIndexed { index, c ->
            when  {
                c.isDigit() -> {
                    graph[i][index] = 0
                }
                c.isLowerCase() -> {
                    graph[i][index] = c - 'a' + 1
                }
                else -> graph[i][index] = c - 'A' + 27
            }
        }
    }
    val pq = PriorityQueue<Node>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (0 < graph[i][j]) {
                pq.offer(Node(i, j, graph[i][j]))
            }
        }
    }
    var total = graph.sumOf { it.sum() }

    while (pq.isNotEmpty()) {
        val (from, to, weight) = pq.poll()
        if (findParent(from) != findParent(to)) {
            total -= weight
            union(from, to)
        }
    }
    val firstParent = findParent(0)
    for (i in 1 until n) {
        if (firstParent != findParent(i)) {
            println(-1)
            exitProcess(0)
        }
    }
    println(total)
}

private fun union(a: Int, b: Int) {
    val pa = findParent(a)
    val pb = findParent(b)
    if (pa < pb) parent[pb] = pa
    else parent[pa] = pb
}

private fun findParent(node: Int): Int {
    if (parent[node] != node) {
        parent[node] = findParent(parent[node])
    }
    return parent[node]
}