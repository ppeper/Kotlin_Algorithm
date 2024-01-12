package boj.Problem2350

import java.util.LinkedList
import java.util.PriorityQueue

data class Node(
    val from: Int = -1,
    val to: Int,
    val weight: Int
)
private lateinit var pq: PriorityQueue<Node>
private lateinit var parent: IntArray
private lateinit var graph: Array<ArrayList<Node>>
private lateinit var queue: LinkedList<Node>
private lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    pq = PriorityQueue(compareByDescending { it.weight })
    parent = IntArray(n + 1) { it }
    graph = Array(n + 1) { ArrayList() }
    visited = BooleanArray(n + 1)
    queue = LinkedList()
    repeat(m) {
        val (from, to, weight) = readLine().split(" ").map { it.toInt() }
        pq.add(Node(from, to, weight))
    }
    while (pq.isNotEmpty()) {
        val curr = pq.poll()
        if (getParentNode(curr.from) != getParentNode(curr.to)) {
            union(curr.from, curr.to)
            graph[curr.from].add(Node(to = curr.to, weight = curr.weight))
            graph[curr.to].add(Node(to = curr.from, weight = curr.weight))
        }
    }
    repeat(k) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        bfs(a, b)
    }
}

private fun bfs(a: Int, b: Int) {
    visited.fill(false)
    queue.clear()
    queue.add(Node(to = a, weight = Int.MAX_VALUE))
    visited[a] = true
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        if (curr.to == b) {
            println(curr.weight)
            break
        }
        for (next in graph[curr.to]) {
            if (!visited[next.to]) {
                visited[next.to] = true
                queue.add(Node(to = next.to, weight = minOf(curr.weight, next.weight)))
            }
        }
    }
}

private fun getParentNode(node: Int): Int {
    if (parent[node] != node) {
        parent[node] = getParentNode(parent[node])
    }
    return parent[node]
}

private fun union(a: Int, b: Int) {
    val parentA = getParentNode(a)
    val parentB = getParentNode(b)
    if (parentA < parentB) {
        parent[parentB] = parentA
    } else {
        parent[parentA] = parentB
    }
}