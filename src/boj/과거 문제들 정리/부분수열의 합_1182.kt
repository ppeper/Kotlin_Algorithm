package boj.`과거 문제들 정리`

var count2 = 0
var S = 0
fun main() {
    val (N, s) = readLine()!!.split(' ').map { it.toInt() }
    S = s
    val list = readLine()!!.split(' ').map { it.toInt() }
    makeSequence(list, 0, 0)
    if (S == 0) println(count2 - 1) else println(count2)
}

private fun makeSequence(list: List<Int>, index: Int, sum: Int) {
    if (index == list.size) {
        if (sum == S) count2++
        return
    }
    makeSequence(list, index + 1, sum)
    makeSequence(list, index + 1, sum + list[index])
}
