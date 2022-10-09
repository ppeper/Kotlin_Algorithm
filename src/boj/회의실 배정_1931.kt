package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    val time = ArrayList<Pair<Int, Int>>()
    var count = 0
    var end = 0
    for (i in 0 until size) {
        val (start, end) = readLine().split(' ').map { it.toInt() }
        time.add(Pair(start, end))
    }
    // 시작 시간과 종료시간으로 정렬
    time.sortWith(compareBy( {it.second}, {it.first} ))
    for (i in time.indices) {
        // 끝나는 시간이 가장 빠른것으로 회의를 개설
        if (end <= time[i].first) {
            end = time[i].second
            count++
        }
    }
    println(count)
}
