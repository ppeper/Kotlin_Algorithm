package programmers.level2

class `할인 행사` {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer = 0
        val number = number.copyOf()
        val map = HashMap<String, Int>()
        for ((i, item) in want.withIndex()) {
            map[item] = i
        }
        for ((i, item) in discount.withIndex()) {
            if (10 <= i) {
                val minus = discount[i - 10]
                val idx = map[minus]
                idx?.let { number[it]++ }
            }
            val idx = map[item] ?: continue
            number[idx]--
            if (number.none { 0 < it }) answer++
        }
        return answer
    }
}