package programmers.level2

class `요격 시스템` {
    fun solution(targets: Array<IntArray>): Int {
        var answer = 0
        targets.sortBy { it[1] }

        var end = Integer.MIN_VALUE

        for (target in targets) {
            val (s, e) = target
            if (s >= end) {
                answer++
                end = e
            }
        }
        return answer
    }
}