package programmers.kakao.KAKAO_BLIND_2023

import kotlin.math.abs

class `KAKAO_BLIND_2023_미로 탈출 명령어` {
    private val dx = intArrayOf(1, 0, 0, -1)
    private val dy = intArrayOf(0, -1, 1, 0)
    private val oper = arrayOf("d", "l", "r", "u")
    private var N = 0
    private var M = 0
    private var R = 0
    private var C = 0
    private var answer = ""

    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        N = n
        M = m
        R = r - 1
        C = c - 1
        val diff = abs(r - 1 - (x - 1)) + abs(c - 1 - (y - 1))
        dfs(x - 1, y - 1, k, diff, "")
        if (answer.isEmpty()) answer = "impossible"
        return answer
    }

    private fun remainEqual(diff: Int, k: Int): Boolean {
        return (diff % 2 == 0 && k % 2 == 0) || (diff % 2 == 1 && k % 2 == 1)
    }

    private fun dfs(x: Int, y: Int, k: Int, diff: Int, route: String): Boolean {
        if (k == 0 && diff == 0) {
            answer = route
            return true
        }
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until N && ny in 0 until M && diff <= k) {
                if (remainEqual(diff, k) && dfs(nx, ny, k - 1,
                        abs(nx - R) + abs(ny - C), route + oper[i])) {
                    return true
                }
            }
        }
        return false
    }
}