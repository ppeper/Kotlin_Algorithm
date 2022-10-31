package boj

const val MOD = 9901
fun main() {
    val size = readln().toInt()
    // 빈칸, 왼쪽사자, 오른쪽 사자
    val cage = Array(size + 1) { LongArray(3) }
    for (i in 1 until cage.size) {
        if (i == 1) {
            cage[i][0] = 1
            cage[i][1] = 1
            cage[i][2] = 1
        } else {
            // 빈칸이 가능 -> 빈칸, 왼쪽, 오른쪽
            cage[i][0] = (cage[i - 1][0] + cage[i - 1][1] + cage[i - 1][2]) % MOD
            // 왼쪽에 사자 -> 빈칸, 오른쪽
            cage[i][1] = (cage[i - 1][0] + cage[i - 1][2]) % MOD
            // 오른쪽에 사자 -> 빈칸, 왼쪽
            cage[i][2] = (cage[i - 1][0] + cage[i - 1][1]) % MOD
        }
    }
    val answer = (cage[size][0] + cage[size][1] + cage[size][2]) % MOD
    println(answer)
}