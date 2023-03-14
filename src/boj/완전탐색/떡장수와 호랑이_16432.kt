package boj.완전탐색

import java.util.*
import kotlin.system.exitProcess

private lateinit var graph: Array<LinkedList<Int>>
private lateinit var visited: Array<BooleanArray>
private lateinit var st: StringTokenizer
private var n = 0
fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    graph = Array(n + 1) { LinkedList() }
    visited = Array(n + 1) { BooleanArray(10) }
    val list = IntArray(n + 1)
    for (day in 1..n) {
        st = StringTokenizer(readLine())
        val count = st.nextToken().toInt()
        for (i in 0 until count) {
            graph[day].add(st.nextToken().toInt())
        }
    }
    deliverRiceCake(0, 1, list)
    println(-1)
}

private fun deliverRiceCake(prev: Int, day: Int, list: IntArray) {
    if (n < day) {
        for (i in 1..n) {
            println(list[i])
        }
        exitProcess(0)
    }
    for (next in graph[day]) {
        if (next != prev && !visited[day][next]) {
            visited[day][next] = true
            list[day] = next
            deliverRiceCake(next, day + 1, list)
        }
    }
}
