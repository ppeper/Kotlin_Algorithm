package boj.Problem2469

private lateinit var ladder: Array<String>
private var lineIndex = 0
private var answer = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val n = readLine().toInt()
    val start = StringBuilder()
    val finish = StringBuilder(readLine())
    for (i in 0 until k) {
        start.append('A' + i)
    }
    ladder = Array(n) { index -> readLine().also {
        if (it.contains('?')) lineIndex = index
    }}
    for (i in 0 until lineIndex) {
        for (j in ladder[i].indices) {
            if (ladder[i][j] == '-') swap(j, start)
        }
    }
    for (x in n - 1 downTo lineIndex) {
        for (y in ladder[x].indices) {
            if (ladder[x][y] == '-') swap(y, finish)
        }
    }
    for (m in 0 until k - 1) {
        if (start[m] != finish[m]) {
            swap(m, start)
            answer.append('-')
        } else {
            answer.append('*')
        }
    }
    if (start.toString() == finish.toString()) {
        println(answer)
    } else {
        println("x".repeat(k - 1))
    }
}

private fun swap(i: Int, sb: StringBuilder) {
    sb[i] = sb[i + 1].also { sb[i + 1] = sb[i] }
}