package programmers.level1

import kotlin.math.abs

class DivideHap {
    fun solution(left: Int, right: Int): Int {
        var answer = 0
        (left..right).forEach {
            if (check(it)) {
                answer += it
            } else {
                answer -= it
            }
        }
        return answer
    }

    private fun check(number: Int): Boolean {
        var count = 0
        for (i in 1..abs(number)) {
            if (number % i == 0) {
                count++
            }
        }
        return count % 2 == 0
    }
}