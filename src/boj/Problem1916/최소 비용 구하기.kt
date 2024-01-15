package boj.Problem1916

import java.util.*

data class Node(
    val to: Int,
    val cost: Int
)
private lateinit var dist: IntArray
private lateinit var graph: Array<LinkedList<Node>>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dist = IntArray(n + 1) { 987654321 }
    graph = Array(n + 1) { LinkedList() }
    val m = readLine().toInt()
    repeat(m) {
        val (from, to, cost) = readLine().split(" ").map { it.toInt() }
        graph[from].add(Node(to, cost))
    }
    val (start, destination) = readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Node>(compareBy { it.cost })
    dist[start] = 0
    pq.add(Node(start, 0))
    while (pq.isNotEmpty()) {
        val (to, cost) = pq.poll()
        // 이미 최소거리로 업데이트 -> 방문한 지역
        if (dist[to] < cost) continue
        for (nextNode in graph[to]) {
            val nextDistance = nextNode.cost + cost
            if (nextDistance < dist[nextNode.to]) {
                dist[nextNode.to] = nextDistance
                pq.add(Node(nextNode.to, nextDistance))
            }
        }
    }
    println(dist[destination])
}