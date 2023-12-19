package programmers.level2

import java.util.*

private lateinit var graph: Array<LinkedList<Pair<Int, Int>>>
private lateinit var distance: IntArray

class 배달 {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        initRoad(N, road)
        dijkstra()
        println(distance.toList())
        return distance.count { it <= k }
    }

    private fun dijkstra() {
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.add(Pair(1, 0))
        distance[1] = 0
        while (pq.isNotEmpty()) {
            val (to, cost) = pq.poll()
            // 이미 최단거리로 업데이트
            if (distance[to] < cost) continue
            // 현 시작 노드에서의 인접 노드들
            for ((nextNode, nextCost) in graph[to]) {
                // 다음 노드까지의 거리가 현재 노트를 지나가는 것 보다 작으면 업데이트
                if (nextCost + cost < distance[nextNode]) {
                    distance[nextNode] = nextCost + cost
                    pq.add(Pair(nextNode, nextCost + cost))
                }
            }
        }
    }

    private fun initRoad(N: Int, road: Array<IntArray>) {
        distance = IntArray(N + 1) { 987654321 }
        graph = Array(N + 1) { LinkedList() }
        road.forEach { (from, to, cost) ->
            graph[from].add(Pair(to, cost))
            graph[to].add(Pair(from, cost))
        }
    }
}