package programmers.kakao.KAKAO_INTERNSHIP_2022

import kotlin.math.min

const val INF = 987654321
class `코딩 테스트 공부` {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        // 도달해랴하는 알고력과 코딩력의 최대값을 구해줌
        var algoMax = alp
        var codingMax = cop
        problems.forEach { problem ->
            algoMax = algoMax.coerceAtLeast(problem[0])
            codingMax = codingMax.coerceAtLeast(problem[1])
        }
        // dp 배열 ex) dp[10][10] -> 알고력 10, 코딩력 10을 풀기위한 시간
        val dp = Array(151) { IntArray(151) { INF } }
        dp[alp][cop] = 0
        for (i in alp.. algoMax) {
            for (j in cop..codingMax) {
                if (i < algoMax) {
                    dp[i + 1][j] = dp[i + 1][j].coerceAtMost(dp[i][j] + 1)
                }
                if (j < codingMax) {
                    dp[i][j + 1] = dp[i][j + 1].coerceAtMost(dp[i][j] + 1)
                }
                problems.forEach { p ->
                    val (alp_req, cop_req, alp_rwd, cop_rwd, cost) = p
                    if (alp_req <= i && cop_req <= j) {
                        val idx_i = min(i + alp_rwd, algoMax)
                        val idx_j = min(j + cop_rwd, codingMax)
                        dp[idx_i][idx_j] = dp[idx_i][idx_j].coerceAtMost(dp[i][j] + cost)
                    }
                }
            }
        }
        return dp[algoMax][codingMax]
    }
}

fun main() {
    val test = `코딩 테스트 공부`()
    val problems = arrayOf(intArrayOf(10, 15, 2, 1, 2), intArrayOf(20, 20, 3, 3, 4))
    println(test.solution(10, 10, problems))
}