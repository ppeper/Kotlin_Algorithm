package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    val set = HashSet<String>()
    repeat(N) { set.add(readLine()) }
    var count = 0
    repeat(M) {
        val word = readLine()
        if(set.contains(word)) count++
    }
    println(count)
}