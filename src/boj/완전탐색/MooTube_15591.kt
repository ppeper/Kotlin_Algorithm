package boj.완전탐색

import java.lang.StringBuilder
import java.util.*

data class Tube(val node: Int, val weight: Int)
private lateinit var graph: Array<LinkedList<Tube>>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, q) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { LinkedList() }
    repeat(n - 1) {
        val (p, q, r) = readLine().split(" ").map { it.toInt() }
        graph[p].add(Tube(q, r))
        graph[q].add(Tube(p, r))
    }
    val sb = StringBuilder()
    repeat(q) {
        val (k, v) = readLine().split(" ").map { it.toInt() }
        var count = 0
        val visited = BooleanArray(graph.size)
        val queue = LinkedList<Int>()
        queue.offer(v)
        visited[v] = true
        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            for (nextNode in graph[curr]) {
                val weight = nextNode.weight
                val node = nextNode.node
                if (!visited[node] && k <= weight) {
                    visited[node] = true
                    queue.offer(node)
                    count++
                }
            }
        }
        sb.append("$count\n")
    }
    println(sb)
}