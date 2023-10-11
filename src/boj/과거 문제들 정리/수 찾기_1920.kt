package boj.`과거 문제들 정리`

fun main() {
    val N = readln().toInt()
    val list = readLine()!!.split(' ').map { it.toLong() }.toSet()
    val M = readln().toInt()
    val checkList = readLine()!!.split(' ').map { it.toLong() }
    for (i in checkList.indices) {
        if (list.contains(checkList[i])) {
            println(1)
        } else {
            println(0)
        }
    }
}