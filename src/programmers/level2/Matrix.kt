package programmers.level2

class Matrix {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr2[0].size) }
        for (row in arr1.indices) {
            for (col in 0 until arr2[0].size) {
                for (k in arr2.indices) {
                    answer[row][col] += arr1[row][k] * arr2[k][col]
                }
            }
        }
        return answer
    }
}