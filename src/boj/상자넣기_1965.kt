package boj

fun main() {
    val size = readln().toInt()
    val box = readLine()!!.split(' ').map { it.toInt() }
    val dp = IntArray(size) { 1 }
    for (i in 0 until box.size - 1) {
        for (j in i + 1 until box.size) {
            // 박스가 더 크면 추가
            if (box[i] < box[j]) {
                dp[j] = dp[j].coerceAtLeast(dp[i] + 1)
            }
        }
    }
    println(dp.max())
}