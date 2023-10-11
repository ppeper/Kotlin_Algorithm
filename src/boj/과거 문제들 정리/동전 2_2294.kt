package boj.`과거 문제들 정리`

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val coinList = mutableSetOf<Int>().apply {
        repeat(n) {
            val coin = readln().toInt()
            // 만들려는 돈보다 coin이 더 크면 볼 필요가 없음
            if (coin <= k) {
                add(coin)
            }
        }
    }.toList()
    val dp = Array(k + 1) { 10001 }
    // 각 수까지 만들 수 있는지 확인
    for (i in 1..k) {
        if (i in coinList) {
            // 해당 동전이 있으므로 1개로 만들 수 있음
            dp[i] = 1
        } else {
            for (coin in coinList) {
                // 동전의 가치보다 만드려는 돈이 더 클때
                if (coin < i) {
                    dp[i] = dp[i].coerceAtMost(dp[i - coin] + 1)
                }
            }
        }
    }
    if (dp[k] == 10001) println(-1) else println(dp[k])
}