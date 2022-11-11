package boj

fun main() {
    val size = readln().toInt()
    val listA = readLine()!!.split(' ').map { it.toInt() }.sorted()
    val listB = readLine()!!.split(' ').map { it.toInt() }.sortedDescending()
    var answer = 0
    for (i in listA.indices) {
        answer += listA[i] * listB[i]
    }
    println(answer)
}