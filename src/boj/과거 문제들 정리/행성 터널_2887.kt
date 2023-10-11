package boj.`과거 문제들 정리`

import java.util.LinkedList
import java.util.PriorityQueue
import kotlin.math.abs

private lateinit var visited: BooleanArray
private lateinit var pq: PriorityQueue<Pair<Int, Int>>
private lateinit var graph: Array<LinkedList<Pair<Int, Int>>>
data class Planet (val id: Int, val x: Int, val y: Int, val z: Int)
fun main() = with(System.`in`.bufferedReader()) {
    val list = ArrayList<Planet>()
    val n = readLine().toInt()
    graph = Array(n) { LinkedList() }
    visited = BooleanArray(n)
    for (i in 0 until n) {
        val (x, y, z) = readLine().split(" ").map { it.toInt() }
        list.add(Planet(i, x, y, z))
    }
    // 좌표의 거리
    initGraph(list)
    var cost = 0
    pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.offer(Pair(0, 0))
    while (pq.isNotEmpty()) {
        val curr = pq.poll()
        if (!visited[curr.first]) {
            visited[curr.first] = true
            cost += curr.second
            for (nextNode in graph[curr.first]) {
                if (!visited[nextNode.first]) {
                    pq.offer(nextNode)
                }
            }
        }
    }
    println(cost)
}

private fun initGraph(list: ArrayList<Planet>) {
    list.sortBy { it.x }
    for (i in 0 until list.size - 1) {
        val dist = (abs(list[i].x - list[i + 1].x))
        graph[list[i].id].offer(Pair(list[i + 1].id, dist))
        graph[list[i + 1].id].offer(Pair(list[i].id, dist))
    }
    list.sortBy { it.y }
    for (i in 0 until list.size - 1) {
        val dist = (abs(list[i].y - list[i + 1].y))
        graph[list[i].id].offer(Pair(list[i + 1].id, dist))
        graph[list[i + 1].id].offer(Pair(list[i].id, dist))
    }
    list.sortBy { it.z }
    for (i in 0 until list.size - 1) {
        val dist = (abs(list[i].z - list[i + 1].z))
        graph[list[i].id].offer(Pair(list[i + 1].id, dist))
        graph[list[i + 1].id].offer(Pair(list[i].id, dist))
    }
}
