package programmers.level3

import java.util.PriorityQueue

// n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
//
//노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
//
//  제한사항
//  노드의 개수 n은 2 이상 20,000 이하입니다.
//  간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
//  vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

const val INF = 10000
data class Node (
    val end: Int,
    val weight: Int
)
class LongestNode {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val dist = IntArray(n) {INF}
        // 그래프 인접 리스트
        val graph = Array(n) { ArrayList<Node>() }
        edge.forEach {
            graph[it[0] - 1].add(Node(it[1] - 1, 1))
            graph[it[1] - 1].add(Node(it[0] - 1, 1))
        }
        dijkstra(1, dist, graph)
        return dist.filter {it != INF}.count { it == dist.maxOrNull() }
    }
    private fun dijkstra(start: Int, dist: IntArray, graph: Array<ArrayList<Node>>) {
        // 시작 노드 거리
        dist[start - 1] = 0
        // 우선순위 큐
        val pq = PriorityQueue<Node>(compareBy { it.weight })
        // 시작노드
        pq.add(Node(start - 1, 0))
        while (pq.isNotEmpty()) {
            val curr = pq.poll()
            for (node in graph[curr.end]) {
                val nextNode = node.end
                if (node.weight + curr.weight < dist[nextNode]) {
                    dist[nextNode] = node.weight + curr.weight
                    pq.add(Node(nextNode, node.weight + curr.weight))
                }
            }
        }
    }
}

fun main() {
    val test = LongestNode()
    println(test.solution(6, arrayOf(
        intArrayOf(3,6),
        intArrayOf(4,3),
        intArrayOf(3,2),
        intArrayOf(1,3),
        intArrayOf(1,2),
        intArrayOf(2,4),
        intArrayOf(5,2)))
    )
}