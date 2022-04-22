package Level1

class Matrix {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val answer = Array(arr1.size) { IntArray(arr1[0].size) }
        for (row in arr1.indices) {
            for (col in arr1[0].indices) {
                answer[row][col] = arr1[row][col] + arr2[row][col]
            }
        }
        return answer
    }
}