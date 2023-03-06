package boj.bitmask

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var N = n
    var count = 0
    while (k < Integer.bitCount(N)) {
        N += 1
        count++
    }
    println(count)
}