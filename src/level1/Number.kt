package level1

class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = longArrayOf()
        for (i in 1..n) {
            answer += i * x.toLong()
        }
        return answer
    }
}

// 람다식으로 풀 수 있다.
fun solution(x: Int, n: Int): LongArray = LongArray(n) { index ->
    x.toLong() * (index + 1)
}