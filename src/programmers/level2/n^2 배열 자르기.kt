package programmers.level2

import kotlin.math.max

class `n^2 배열 자르기` {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray((right - left + 1).toInt())
        var index = 0
        for (i in left..right) {
            answer[index++] = max(i / n, i % n).toInt() + 1
        }
        return answer
    }
}