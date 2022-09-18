package programmers.level1

class Divider {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        arr.sort()
        return if (arr.none { it % divisor == 0 }) {
            intArrayOf(-1)
        } else {
            arr.filter { it % divisor == 0 }.toIntArray()
        }
    }
}