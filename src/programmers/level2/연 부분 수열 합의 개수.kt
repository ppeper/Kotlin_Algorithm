package programmers.level2

class `연 부분 수열 합의 개수` {
    private lateinit var sum: IntArray
    fun solution(elements: IntArray): Int {
        val answer = mutableSetOf<Int>()
        sum = IntArray(elements.size * 2 + 1)
        val size = elements.size
        for (i in 0 until sum.size - 1) {
            sum[i + 1] = elements[i % size] + sum[i]
        }
        for (start in 1..elements.size) {
            for (length in elements.indices) {
                answer.add(sum[start + length] - sum[start - 1])
            }
        }
        return answer.size
    }
}