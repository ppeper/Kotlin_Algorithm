package boj.Problem22865

import java.util.*

private lateinit var graph: Array<LinkedList<Pair<Int, Int>>>
private lateinit var friends: List<Int>
private lateinit var distance: Array<IntArray>
private var answer = 0
private var currDistance = Int.MIN_VALUE
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    graph = Array(n + 1) { LinkedList() }
    distance = Array(3) { IntArray(n + 1) { Int.MAX_VALUE } }
    friends = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()
    repeat(m) {
        val (from, to, dist) = readLine().split(" ").map { it.toInt() }
        graph[from].add(Pair(to, dist))
        graph[to].add(Pair(from, dist))
    }
    friends.forEachIndexed { index, start ->
        dijkstra(index, start)
    }
    for (i in 1..n) {
        val min = distance[0][i].coerceAtMost(distance[1][i]).coerceAtMost(distance[2][i])
        if (currDistance < min) {
            currDistance = min
            answer = i
        }
    }
    println(answer)
}

private fun dijkstra(index: Int, start: Int) {
    distance[index][start] = 0
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.add(Pair(start, 0))
    while (pq.isNotEmpty()) {
        val (curr, dist) = pq.poll()
        if (distance[index][curr] < dist) continue
        for ((next, nextDist) in graph[curr]) {
            if (dist + nextDist < distance[index][next]) {
                distance[index][next] = dist + nextDist
                pq.add(Pair(next, dist + nextDist))
            }
        }
    }
}
