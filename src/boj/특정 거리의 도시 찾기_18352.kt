package boj

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Scanner

fun main() = with(Scanner(System.`in`)){
    data class Node(val end: Int, val weight: Int)
    val (N, M, K, X) = nextLine().split(' ').map { it.toInt() }
    val graph = Array(N) { LinkedList<Node>() }
    val distance = IntArray(N) { Int.MAX_VALUE }
    repeat(M) {
        val from = nextInt() - 1
        val to = nextInt() - 1
        graph[from].add(Node(to, 1))
    }
    // 시작 노드 거리는 0
    distance[X - 1] = 0
    val pq = PriorityQueue<Node>(compareBy { it.weight })
    pq.offer(Node(X - 1, 0))
    while (pq.isNotEmpty()) {
        val curr = pq.poll()
        if (distance[curr.end] < curr.weight) continue
        for (node in graph[curr.end]) {
            val nextNode = node.end
            val nextDistance = node.weight + curr.weight
            if (nextDistance < distance[nextNode]) {
                distance[nextNode] = nextDistance
                pq.offer(Node(nextNode, nextDistance))
            }
        }
    }
    if (distance.none { it == K }) {
        println(-1)
    } else {
        for ((index, value) in distance.withIndex()) {
            if (value == K) {
                println(index + 1)
            }
        }
    }
}