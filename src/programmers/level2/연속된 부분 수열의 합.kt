package programmers.level2

class `연속된 부분 수열의 합` {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer = intArrayOf(0, sequence.size)
        var left = 0
        var right = 0
        var sum = sequence[right]
        while(left < sequence.size) {
            if (sum < k) {
                if (right == sequence.size - 1) break
                sum += sequence[++right]
                continue
            }
            if (sum == k) {
                if(right - left < answer[1] - answer[0]) {
                    answer[0] = left
                    answer[1] = right
                }
            }
            sum -= sequence[left++]
        }
        return answer
    }
}