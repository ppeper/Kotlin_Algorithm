package level1

import kotlin.math.sqrt

// 조합 사용
class MakePrime {
    var answer = 0
    lateinit var visited: BooleanArray
    fun solution(nums: IntArray): Int {
        visited = BooleanArray(nums.size)
        combination(nums, 0, 0,0)
        return answer
    }

    private fun combination(nums: IntArray, sum: Int, start: Int, depth: Int) {
        if (depth == 3) {
            if (isPrime(sum)) {
                answer++
            }
            return
        } else {
            for (i in start.until(nums.size)) {
                if (!visited[i]) {
                    visited[i] = true
                    combination(nums, sum + nums[i], i, depth + 1)
                    visited[i] = false
                }
            }
        }
    }

    private fun isPrime(n: Int): Boolean {
        if (n <= 2) {
            return false
        } else {
            for (i in 2..sqrt(n.toDouble()).toInt()) {
                if (n % i == 0) {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    val prime = MakePrime()
    prime.solution(intArrayOf(1,2,7,6,4))
}