package boj.Problem2012

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = ArrayList<Long>().apply {
        repeat(n) { add(readLine().toLong()) }
    }.sorted()

    println(
        list.foldIndexed(0L) { index, acc, i ->
            acc + abs(i - (index + 1))
        }
    )
}