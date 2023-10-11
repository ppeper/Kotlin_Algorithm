package boj.`과거 문제들 정리`

fun main() {
    val (N, K) = readLine()!!.split(' ').map { it.toInt() }
    val prime = BooleanArray(N + 1) { true }
    var count = 0
    var answer = 0
    loop@ for (i in 2..N) {
        if (prime[i]) {
            for (j in i..N step i) {
                if (!prime[j]) continue
                prime[j] = false
                count++
                if (count == K) {
                    answer = j
                    break@loop
                }
            }
        }
    }
    println(answer)
}