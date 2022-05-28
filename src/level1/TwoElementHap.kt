package level1

import java.util.*


class TwoElementHap {
    fun solution(numbers: IntArray): IntArray {
        val addSet: MutableSet<Int> = HashSet()
        for (i in numbers.indices) {
            for (j in i + 1 until numbers.size) {
                addSet.add(numbers[i] + numbers[j])
            }
        }
        return addSet.sorted().toIntArray()
    }
}