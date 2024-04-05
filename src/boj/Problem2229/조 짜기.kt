package boj.Problem2229

// 최대한 2명으로 팀을 만드는게 유리하다
private lateinit var student: List<Int>
// dp[i] i번 까지의 최대 점수
private lateinit var dp: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    dp = IntArray(n) { -1 }
    student = readLine().split(" ").map { it.toInt() }
    val answer = search(0)
    println(answer)
}

private fun search(i: Int): Int {
    if (i == dp.size) return 0
    if (dp[i] != -1) return dp[i]

    val currScore = student[i]
    for (j in i until student.size) {
        val max = currScore.coerceAtLeast(student[j])
        val min = currScore.coerceAtMost(student[j])
        dp[i] = dp[i].coerceAtLeast(search(j + 1) + (max - min))
    }
    return dp[i]
}
