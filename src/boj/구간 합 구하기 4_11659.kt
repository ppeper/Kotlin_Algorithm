package boj

fun main() {
    val (N, M) = readLine()!!.split(' ').map { it.toInt() }
    val answer = IntArray(M)
    val list = readLine()!!.split(' ').map { it.toInt() }
    val sum = IntArray(list.size + 1) { 0 }
    for (k in list.indices) {
        sum[k + 1] = sum[k] + list[k]
    }
    for (index in 0 until M) {
        val (i, j) = readLine()!!.split(' ').map { it.toInt() }
        answer[index] = sum[j] - sum[i - 1]
    }
    answer.forEach {
        println(it)
    }
}