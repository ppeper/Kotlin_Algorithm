package programmers.level2

class `롤케이크 자르기` {
    fun solution(topping: IntArray): Int {
        var answer = 0
        var left = 0
        var right = topping.distinct().count()
        val max = topping.max()
        // 토핑 개수 init
        val rightTopping = (0..max).map { index ->
            topping.count { it == index }
        }.toIntArray()
        val leftTopping = IntArray(max + 1)
        for (t in topping) {
            (--rightTopping[t]).also { remain ->
                if (remain == 0) right--
                if (++leftTopping[t] == 1) left++
            }
            if (left == right) answer++
        }
        return answer
    }
}