package level1

import kotlin.math.pow
import kotlin.math.sqrt

class SqrtCheck {
    fun solution(n: Long): Long {
        val number = sqrt(n.toDouble()).toLong()
        // number의 제곱이 n과 같을때
        return if (number.toDouble().pow(2.0) == n.toDouble()) {
            (number + 1).toDouble().pow(2.0).toLong()
        } else {
            -1
        }
    }
}