package programmers.kakao.KAKAO_BLIND_2022

class Solution {
    private val SCORE = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    private var pick = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    private var result = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    // 점수의 차이
    private var diff = -1
    fun solution(n: Int, info: IntArray): IntArray {
        dfs(0, n, info)
        return if (diff == -1) intArrayOf(-1) else result
    }

    private fun dfs(start: Int, n: Int, info: IntArray) {
        // 화살을 다 쏘거나 마지막까지 다 확인
        if (10 < start || n == 0) {
            // 남은 화살은 0점에 추가
            if (n != 0) pick[10] += n
            // 값 구하기
            var ryon = 0
            var apeach = 0
            for (i in info.indices) {
                if (info[i] < pick[i]) ryon += SCORE[i]
                if (info[i] > pick[i]) apeach += SCORE[i]
            }
            // 차이 비교
            val overScore = ryon - apeach
            if (overScore == 0) return
            if (diff < overScore) {
                diff = overScore
                result = pick.clone()
            } else if (diff == overScore) {
                for (i in 10 downTo 0) {
                    // 낮은 점수를 더 많이 맞힌 경우
                    if (result[i] < pick[i]) {
                        result = pick.clone()
                        break
                    } else if (pick[i] < result[i]) {
                        break
                    }
                }
            }
            // 추가되었던 0점 화살개수 초기화
            pick[10] = 0
            return
        }
        // 라이언이 이기는 경우
        // 남은 화살을 확인해봐야 한다
        val winCount = info[start] + 1
        if (winCount <= n) {
            pick[start] = winCount
            dfs(start + 1, n - winCount, info)
            pick[start] = 0
        }
        // 어피치가 이기는 경우
        dfs(start + 1, n, info)
    }
}

fun main() {
    val s = Solution()
    val answer = s.solution(5, intArrayOf(2,1,1,1,0,0,0,0,0,0,0))
    println(answer.toList())
}