package boj.Problem1504

import java.util.LinkedList
import java.util.PriorityQueue
import kotlin.math.min

data class Node(
    val to: Int,
    val cost: Int
)
private const val INF = 200_000_000
private lateinit var graph: Array<LinkedList<Node>>
private lateinit var distance: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, e) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { LinkedList() }
    distance = IntArray(n + 1) { INF }
    repeat(e) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        graph[from].add(Node(to, cost))
        graph[to].add(Node(from, cost))
    }
    val (a, b) = readLine().split(" ").map { it.toInt() }
    val answer1: Int
    val answer2: Int
    val distAtoB = dijkstra(a, b)
    answer1 = dijkstra(1, a) + distAtoB + dijkstra(b, n)
    answer2 = dijkstra(1, b) + distAtoB + dijkstra(a, n)
    if (INF <= answer1 && INF <= answer2) {
        println(-1)
    } else {
        println(min(answer1, answer2))
    }
}

private fun dijkstra(from: Int, to: Int): Int {
    val pq = PriorityQueue<Node>(compareBy { it.cost })
    distance.fill(INF)
    distance[from] = 0
    pq.add(Node(from, 0))
    while (pq.isNotEmpty()) {
        val curr = pq.poll()
        if (distance[curr.to] < curr.cost) continue
        for (nextNode in graph[curr.to]) {
            val dist = nextNode.cost + curr.cost
            if (dist < distance[nextNode.to]) {
                distance[nextNode.to] = dist
                pq.add(Node(nextNode.to, dist))
            }
        }
    }
    return distance[to]
}
