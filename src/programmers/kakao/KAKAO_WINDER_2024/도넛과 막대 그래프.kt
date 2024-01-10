package programmers.kakao.KAKAO_WINDER_2024

const val SIZE = 4
const val MAX = 1_000_001
data class Node(
    var inDegree: Int = 0,
    var outDegree: Int = 0
)
class `도넛과 막대 그래프` {
    private lateinit var answer: IntArray
    private lateinit var graph: Array<Node>
    fun solution(edges: Array<IntArray>): IntArray {
        answer = IntArray(SIZE)
        graph = Array(MAX) { Node() }
        edges.forEach { (a, b) ->
            graph[a].outDegree++
            graph[b].inDegree++
        }
        for ((number, node) in graph.withIndex()) {
            if (2 <= node.outDegree && node.inDegree == 0) {
                answer[0] = number
            } else if (node.outDegree == 0 && 0 < node.inDegree) {
                answer[2]++
            } else if (2 <= node.outDegree && 2 <= node.inDegree) {
                answer[3]++
            }
        }
        answer[1] = graph[answer[0]].outDegree - answer[2] - answer[3]
        return answer
    }
}