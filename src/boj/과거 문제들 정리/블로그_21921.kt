package boj.`과거 문제들 정리`

fun main() {
    val (N, X) = readLine()!!.split(' ').map { it.toInt() }
    val list = readLine()!!.split(' ').map { it.toInt() }
    var visitors = 0
    var count = 1
    var buffer = 0
    for (i in 0..N - X) {
        if (i == 0) {
            for (j in 0 until X) {
                buffer += list[j]
            }
            visitors = buffer
        } else {
            buffer = buffer - list[i - 1] + list[i + X - 1]
            if (visitors < buffer) {
                visitors = buffer
                count = 1
            } else if (visitors == buffer) {
                count++
            }
        }
    }
    if (visitors == 0) println("SAD") else println("${visitors}\n${count}")
}