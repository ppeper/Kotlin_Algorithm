package boj.최단거리.Problem14431

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

private lateinit var graph: Array<LinkedList<Pair<Int, Int>>>
private lateinit var dist: IntArray
const val INF = 987654321
fun main() = with(System.`in`.bufferedReader()) {
    val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
    val n = readLine().toInt()
    // 시작 + 도착 + n개의 경유지점
    dist = IntArray(n + 2) { INF }
    graph = Array(n + 2) { LinkedList() }
    val list = ArrayList<Pair<Int, Int>>()
        .apply {
            add(Pair(x1, y1))
            repeat(n) {
                val (x, y) = readLine().split(" ").map { it.toInt() }
                add(Pair(x, y))
            }
            add(Pair(x2, y2))
        }
    for (i in 0 until list.size - 1) {
        val (x1, y1) = list[i]
        for (j in i + 1 until list.size) {
            val (x2, y2) = list[j]
            val dist = getDistance(x1, y1, x2, y2)
            if (isPrime(dist)) {
                graph[i].add(Pair(j, dist))
                graph[j].add(Pair(i, dist))
            }
        }
    }
    dijkstra()
    if (dist[n + 1] == INF) println(-1) else println(dist[n + 1])
}

private fun dijkstra() {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.offer(Pair(0, 0))
    dist[0] = 0
    while (pq.isNotEmpty()) {
        val (node, distance) = pq.poll()
        if (dist[node] < distance) continue
        // 갈 수 있는 노드들 확인
        for (adj in graph[node]) {
            val nextNode = adj.first
            // 경유해서 가는 거리
            val updateDistance = adj.second + distance
            if (updateDistance < dist[nextNode]) {
                dist[nextNode] = updateDistance
                pq.offer(Pair(nextNode, updateDistance))
            }
        }
    }
}

private fun isPrime(distance: Int): Boolean {
    val range = sqrt(distance.toDouble()).toInt()
    if (distance == 0 || distance == 1) return false
    for (i in 2 ..range) {
        if (distance % i == 0) return false
    }
    return true
}

private fun getDistance(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    val diffX = abs(x1 - x2).toDouble()
    val diffY = abs(y1 - y2).toDouble()
    return sqrt(diffX.pow(2.0) + diffY.pow(2.0)).toInt()
}
