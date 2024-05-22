package boj.Problem5972

import java.util.*

data class Node(
    val to: Int,
    val cost: Int
)
private lateinit var graph: Array<LinkedList<Node>>
private lateinit var distance: IntArray
const val MAX = 987654321
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { LinkedList() }
    distance = IntArray(n + 1) { MAX }
    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        graph[from].add(Node(to, cost))
        graph[to].add(Node(from, cost))
    }
    dijkstra()
    println(distance[n])
}

private fun dijkstra() {
    val pq = PriorityQueue<Node>(compareBy { it.cost })
    distance[1] = 0
    pq.add(Node(1, 0))
    while (pq.isNotEmpty()) {
        val (to, cost) = pq.poll()
        if (distance[to] < cost) continue

        for (nextNode in graph[to]) {
            val dist = nextNode.cost + cost
            if (dist < distance[nextNode.to]) {
                distance[nextNode.to] = dist
                pq.add(Node(nextNode.to, dist))
            }
        }
    }
}
