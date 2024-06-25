package boj.Problem20922

private lateinit var list: List<Int>
private lateinit var numberCount: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    list = readLine().split(" ").map { it.toInt() }
    numberCount = IntArray(100_001)
    var answer = 1
    var start = 0
    for (end in list.indices) {
        numberCount[list[end]]++
        // k개에 맞게 범위를 지정해 준다
        while (k < numberCount[list[end]]) {
            numberCount[list[start++]]--
        }
        answer = answer.coerceAtLeast(end - start + 1)
    }
    println(answer)
}