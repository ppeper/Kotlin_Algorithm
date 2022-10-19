package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var lcs: Array<IntArray>
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val firstWord = readLine()
    val secondWord = readLine()
    lcs = Array(firstWord.length + 1) { IntArray(secondWord.length + 1) }
    for (i in lcs.indices) {
        for (j in lcs[0].indices) {
            if (i == 0 || j == 0) {
                lcs[i][j] = 0
            } else if (firstWord[i - 1] == secondWord[j - 1]) {
                // 직전 단어까지 같은 개수와 방금 확인한 개수 +1
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            } else {
                // 직전 단어 -1 를 서로 비교하여 큰수 -> 최장 subSequence
                lcs[i][j] = lcs[i - 1][j].coerceAtLeast(lcs[i][j - 1])
            }
        }
    }
    var count = 0
    for (i in lcs.indices) {
        for (j in lcs[0].indices) {
            count = count.coerceAtLeast(lcs[i][j])
        }
    }
    println(count)
}