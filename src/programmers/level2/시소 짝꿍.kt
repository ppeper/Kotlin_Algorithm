package programmers.level2

class `시소 짝꿍` {
    private var answer = 0L
    private lateinit var countWeight: LongArray
    private lateinit var visited: BooleanArray
    fun solution(weights: IntArray): Long {
        countWeight = LongArray(2001)
        visited = BooleanArray(2001)
        for (weight in weights) {
            countWeight[weight] += 1L
        }
        for (weight in weights) {
            if (visited[weight]) continue
            visited[weight] = true
            val count = countWeight[weight]
            val case1 = countWeight[weight * 2]
            val case2 = if (weight % 2 == 0) countWeight[weight / 2 * 3] else 0
            val case3 = if (weight % 3 == 0) countWeight[weight / 3 * 4] else 0
            if (2 <= count) answer += (count * (count - 1)) / 2L
            if (0 < case1) answer += count * case1
            if (0 < case2) answer += count * case2
            if (0 < case3) answer += count * case3
        }
        return answer
    }
}