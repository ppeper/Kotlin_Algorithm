package programmers.kakao.KAKAO_BLIND_2022

class `KAKAO_BLIND_2022_파괴되지 않은 건물` {
    private lateinit var sum: Array<IntArray>
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer = 0
        sum = Array(board.size + 1) { IntArray(board[0].size + 1) }
        for (s in skill) {
            runSkill(s)
        }
        // 가로 누적합
        for (i in 0..board.size) {
            var hap = 0
            for (j in 0..board[0].size) {
                hap += sum[i][j]
                sum[i][j] = hap
            }
        }
        // 세로 누적합
        for (i in 0..board[0].size) {
            var hap = 0
            for (j in 0..board.size) {
                hap += sum[j][i]
                sum[j][i] = hap
            }
        }
        for (i in board.indices) {
            for (j in board.indices) {
                if (0 < sum[i][j] + board[i][j]) answer++
            }
        }
        return answer
    }

    private fun runSkill(s: IntArray) {
        val type = s[0]
        val r1 = s[1]
        val c1 = s[2]
        val r2 = s[3]
        val c2 = s[4]
        val degree = s[5]
        if (type == 1) {
            sum[r1][c1] += -degree
            sum[r2 + 1][c1] += degree
            sum[r1][c2 + 1] += degree
            sum[r2 + 1][c2 + 1] += -degree
        } else {
            sum[r1][c1] += degree
            sum[r2 + 1][c1] += -degree
            sum[r1][c2 + 1] += -degree
            sum[r2 + 1][c2 + 1] += degree
        }
    }
}