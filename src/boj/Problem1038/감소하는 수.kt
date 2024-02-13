package boj.Problem1038

private var numbers = mutableListOf<Long>()
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    if (n <= 10) {
        println(n)
    } else if (1022 < n) {
        println(-1)
    } else {
        for (i in 0..9) {
            decreaseNumber(i.toLong())
        }
        numbers.sort()
        println(numbers[n])
    }
}

private fun decreaseNumber(i: Long) {
    numbers.add(i)
    // 마지막보다 항상 작아야함
    val last = i % 10
    if (last <= 0) return
    for (j in last - 1 downTo 0) {
        decreaseNumber(i * 10 + j)
    }
}
