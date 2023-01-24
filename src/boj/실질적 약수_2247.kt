package boj

private var realMeasure = 0L
private val MOD = 1_000_000
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    for (i in 2..n) {
        realMeasure += i * ((n / i) - 1)
    }
    println(realMeasure % MOD)
}
