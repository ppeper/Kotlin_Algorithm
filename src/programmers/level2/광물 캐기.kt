package programmers.level2

import kotlin.math.pow

class `광물 캐기` {
    private var answer = Int.MAX_VALUE
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        val splitList = minerals.toList().chunked(5)
        runProgram(picks, splitList, 0, 0)
        return answer
    }

    private fun runProgram(picks: IntArray, splitList: List<List<String>>, index: Int, cost: Int) {
        if (splitList.size <= index) {
            answer = answer.coerceAtMost(cost)
            return
        }
        if (picks.sum() == 0) {
            answer = answer.coerceAtMost(cost)
            return
        }
        for (i in 0 until 3) {
            if (picks[i] == 0) continue
            val result = calculateCost(i, splitList[index])
            picks[i]--
            runProgram(picks, splitList, index + 1, cost + result)
            picks[i]++
        }
    }

    private fun calculateCost(type: Int, mineral: List<String>): Int {
        var sum = 0
        for (m in mineral) {
            val typeIndex = when (m) {
                "diamond" -> 0
                "iron" -> 1
                "stone" -> 2
                else -> -1
            }
            sum += if (type - typeIndex <= 0) {
                1
            } else {
                5.0.pow((type - typeIndex).toDouble()).toInt()
            }
        }
        return sum
    }
}