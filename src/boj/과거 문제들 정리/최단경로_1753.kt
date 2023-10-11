package boj.`과거 문제들 정리`

import java.util.*

const val INF = Int.MAX_VALUE
fun main() = with(Scanner(System.`in`)){
    data class Node(val end: Int, val weight: Int)
    val V = nextInt()
    val distance = IntArray(V) { INF }
    val E = nextInt()
    val start = nextInt() - 1
    val graph = Array(V) { LinkedList<Node>() }
    repeat(E) {
        val u = nextInt() - 1
        val v = nextInt() - 1
        val w = nextInt()
        graph[u].add(Node(v, w))
    }
    val pq = PriorityQueue<Node>(compareBy { it.weight })
    // 시작점 0
    distance[start] = 0
    pq.offer(Node(start, 0))
    while (pq.isNotEmpty()) {
        val curr = pq.poll()
        if (distance[curr.end] < curr.weight) continue
        // 가야할 노드 확인
        for (node in graph[curr.end]) {
            val nextNode = node.end
            val nextDistance = node.weight + curr.weight
            if (nextDistance < distance[nextNode]) {
                distance[nextNode] = nextDistance
                pq.offer(Node(nextNode, nextDistance))
            }
        }
    }
    distance.forEach {
        if (it == INF) println("INF") else println(it)
    }
}
