package programmers.kakao.KAKAO_BLIND_2021

class KAKAO_BLIND_2021_합승택시요금 {
    private val INF = 3000000
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer = INF
        val dist = Array(n + 1) { IntArray(n + 1) { INF } }
        for (i in 1..n) {
            dist[i][i] = 0
        }
        // 택시 요금 Init
        for (fare in fares) {
            dist[fare[0]][fare[1]] = fare[2]
            dist[fare[1]][fare[0]] = fare[2]
        }
        // 플로이드
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]
                    }
                }
            }
        }
        // a, b
        for (k in 1..n) {
            answer = answer.coerceAtMost(dist[s][k] + dist[k][a] + dist[k][b])
        }
        return answer
    }
}