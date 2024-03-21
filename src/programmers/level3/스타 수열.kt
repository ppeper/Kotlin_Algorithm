package programmers.level3

class `스타 수열` {
    private var answer = 0
    private lateinit var count: IntArray
    fun solution(a: IntArray): Int {
        count = IntArray(a.size + 1)
        // 숫자의 개수
        for (num in a) {
            count[num]++
        }
        for (i in count.indices) {
            if (count[i] <= answer) continue
            var length = 0
            var index = 0
            while (index < a.size - 1) {
                // 공통된 수가 포함되고 하나의 세트가 같은 값이면 안됨
                if ((a[index] == i || a[index + 1] == i) && a[index] != a[index + 1]) {
                    length++
                    index++
                }
                index++
            }
            answer = answer.coerceAtLeast(length)
        }
        return answer * 2
    }
}