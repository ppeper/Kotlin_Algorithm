package programmers.level2

import kotlin.math.abs
import kotlin.math.min

class `전력망을 둘로 나누기` {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = Int.MAX_VALUE
        for (i in 0 until n - 1) {
            answer = min(answer.toDouble(), check(i, wires).toDouble()).toInt()
        }
        return answer
    }

    private fun check(index: Int, wires: Array<IntArray>): Int {
        val bool = BooleanArray(wires.size)
        val arr1 = ArrayList<Int>()
        val arr2 = ArrayList<Int>()
        arr1.add(wires[index][0])
        arr2.add(wires[index][1])
        bool[index] = true
        do {
            for (i in wires.indices) {
                // 선을 끊은곳은 패스
                if (index != i) {
                    // 값 존재확인
                    val arr = wires[i]
                    // 트리에 포함되면
                    if (arr1.contains(arr[0]) && !bool[i]) {
                        arr1.add(arr[1])
                        bool[i] = true
                    } else if (arr1.contains(arr[1]) && !bool[i]) {
                        arr1.add(arr[0])
                        bool[i] = true
                    } else if (arr2.contains(arr[0]) && !bool[i]) {
                        arr2.add(arr[1])
                        bool[i] = true
                    } else if (arr2.contains(arr[1]) && !bool[i]) {
                        arr2.add(arr[0])
                        bool[i] = true
                    }
                }
            }
        } while (!checkFinish(bool))
        return abs((arr1.size - arr2.size).toDouble()).toInt()
    }

    private fun checkFinish(bool: BooleanArray): Boolean {
        for (b in bool) {
            if (!b) return false
        }
        return true
    }
}