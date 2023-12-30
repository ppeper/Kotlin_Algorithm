package boj.Problem1889

import java.util.*

private lateinit var visited: BooleanArray
private lateinit var inDegree: IntArray
private lateinit var list: Array<LinkedList<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    inDegree = IntArray(n + 1)
    visited = BooleanArray(n + 1)
    list = Array(n + 1) { LinkedList() }
    repeat(n) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        list[it + 1].apply {
            add(a)
            add(b)
        }
        inDegree[a]++
        inDegree[b]++
    }
    val pq = PriorityQueue<Int>()
    for (i in 1..n) {
        if (inDegree[i] < 2) {
            pq.add(i)
        }
    }
    while (pq.isNotEmpty()) {
        val curr = pq.poll()
        if (visited[curr]) continue
        visited[curr] = true
        for (adj in list[curr]) {
            inDegree[adj]--
            if (inDegree[adj] < 2) {
                pq.add(adj)
            }
        }
    }
    val count = inDegree.count { 2 <= it }
    if (count == 0) {
        println(count)
    } else {
        println(count)
        println(inDegree.indices.filter { 2 <= inDegree[it] }.joinToString(" "))
    }
}