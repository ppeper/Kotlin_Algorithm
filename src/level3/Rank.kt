package level3

import java.util.*
import kotlin.collections.ArrayList

// n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
//
//선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//선수의 수는 1명 이상 100명 이하입니다.
//경기 결과는 1개 이상 4,500개 이하입니다.
//results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
//모든 경기 결과에는 모순이 없습니다.

class Rank {
    lateinit var wins: Array<ArrayList<Int>>
    lateinit var loses: Array<ArrayList<Int>>
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        wins = Array(n){ ArrayList() }
        loses = Array(n){ ArrayList() }
        // 토너먼트의 이기고 진 결과
        results.forEach {
            wins[it[0] - 1].add(it[1] - 1)
            loses[it[1] - 1].add(it[0] - 1)
        }
        // 이긴 사람 + 진 사람
        for (i in 0 until n) {
            val wins = bfs(i, n, wins)
            val loses = bfs(i, n, loses)
            if (wins + loses == n - 1) {
                answer++
            }
        }
        return answer
    }
    private fun bfs(start: Int, n: Int, list: Array<ArrayList<Int>>): Int {
        var count = 0
        val visited = BooleanArray(n)
        val q: Queue<Int> = LinkedList()
        q.offer(start)
        // bfs
        while (q.isNotEmpty()) {
            val player = q.poll()
            visited[player] = true
            // player 리스트
            for (node in list[player]) {
                if (!visited[node]) {
                    visited[node] = true
                    q.offer(node)
                    count++
                }
            }
        }
        return count
    }
}