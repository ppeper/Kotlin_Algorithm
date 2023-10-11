package boj.`과거 문제들 정리`

fun main() {
    var size = readln().toInt()
    var count = 0
    while (true) {
        if (size % 5 == 0) {
            println("${size / 5 + count}")
            break
        }
        if (size - 3 < 0) {
            println(-1)
            break
        }
        size -= 3
        count++
    }
}