package level3

// 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
//
//항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//모든 공항은 알파벳 대문자 3글자로 이루어집니다.
//주어진 공항 수는 3개 이상 10,000개 이하입니다.
//tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
//주어진 항공권은 모두 사용해야 합니다.
//만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
//모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

class Travel {
    lateinit var visited: BooleanArray
    var answer = mutableListOf<String>()
    fun solution(tickets: Array<Array<String>>): Array<String> {
        visited = BooleanArray(tickets.size)
        tickets.sortBy {
            it[1]
        }
        answer.add("ICN")
        dfs(answer, "ICN", tickets)
        return answer.toTypedArray()
    }

    private fun dfs(route: MutableList<String>, start: String, tickets: Array<Array<String>>) {
        // 경로 탐색
        for (i in tickets.indices) {
            // 출발지가 같은 티켓
            if (start == tickets[i][0]) {
                // 방문하지 않음
                if (!visited[i]) {
                    // 도착지 경로 추가
                    route.add(tickets[i][1])
                    val des = tickets[i][1]
                    visited[i] = true
                    dfs(route, des, tickets)
                    // 티켓 완료시 종료
                    if (route.size == tickets.size + 1) {
                        return
                    }
                    route.removeLast()
                    visited[i] = false
                }
            }
        }
    }
}