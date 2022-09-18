package programmers.level3

class Connect {
    // 부모 노드를 저장
    private lateinit var parentNode: IntArray
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        // 초기화
        parentNode = IntArray(n) { it }
        // 비용으로 오름차순 정렬
        costs.sortBy { it[2] }
        for (node in costs) {
            // 둘 노드간의 부모가 같지 않으면 선택가능
            if (getParentNode(node[0]) != getParentNode(node[1])) {
                answer += node[2]
                // 부모노드를 업데이트
                parentNode[getParentNode(node[1])] = getParentNode(node[0])
            }
        }
        return answer
    }

    private fun getParentNode(node: Int): Int {
        return if (parentNode[node] == node) {
            node
        } else { // parent 노드가 자기자신이 아님 -> 연결된 부모가 있음
            getParentNode(parentNode[node])
        }
    }
}