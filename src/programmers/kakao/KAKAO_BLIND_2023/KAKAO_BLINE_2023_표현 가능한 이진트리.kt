package programmers.kakao.KAKAO_BLIND_2023

import kotlin.math.pow

class `KAKAO_BLINE_2023_표현 가능한 이진트리` {

    fun solution(numbers: LongArray): IntArray {
        val answer = IntArray(numbers.size)
        numbers.forEachIndexed { index, it ->
            var binary: String = java.lang.Long.toBinaryString(it)
            var height = 0
            while (2.0.pow(height.toDouble()) - 1 < binary.length) {
                height++
            }
            val size = 2.0.pow(height).toInt() - 1
            binary = "0".repeat(size - binary.length) + binary
            answer[index] = binarySearch(binary)
        }
        return answer
    }

    private fun binarySearch(binary: String): Int {
        val mid = binary.length / 2
        val parents = binary[mid]
        val leftChild = binary.slice(0 until mid)
        val rightChild = binary.slice(mid + 1 until binary.length)
        if (parents == '0' && (leftChild[mid / 2] == '1' || rightChild[mid / 2] == '1')) {
            return 0
        }
        if (3 <= leftChild.length) {
            if (binarySearch(leftChild) == 0) return 0
        }
        if (3 <= rightChild.length) {
            if (binarySearch(rightChild) == 0) return 0
        }
        return 1
    }
}

fun main() {
    val s = `KAKAO_BLINE_2023_표현 가능한 이진트리`()
    println(s.solution(longArrayOf(63, 111, 95)).toList())
}