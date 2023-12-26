package boj.Problem6497

import java.util.PriorityQueue

data class Node(
    val from: Int,
    val to: Int,
    val weight: Int
): Comparable<Node> {
    override fun compareTo(other: Node) = this.weight - other.weight
}

private lateinit var pq: PriorityQueue<Node>
private lateinit var parent: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        var cost = 0L
        parent = IntArray(n + 1) { it }
        pq = PriorityQueue()
        repeat(m) {
            val input = readLine().split(" ").map { it.toInt() }
            pq.add(Node(input[0], input[1], input[2]))
            cost += input[2]
        }
        var weightSum = 0L
        while (pq.isNotEmpty()) {
            val (from, to, weight) = pq.poll()
            if (find(from) != find(to)) {
                unionParent(from, to)
                weightSum += weight
            }
        }
        println(cost - weightSum)
    }
}

private fun find(node: Int): Int {
    if (parent[node] != node) {
        parent[node] = find(parent[node])
    }
    return parent[node]
}

private fun unionParent(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    if (pa < pb) parent[pb] = pa
    else parent[pa] = pb
}