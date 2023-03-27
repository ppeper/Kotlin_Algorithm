package boj.Problem14567

import java.util.*

private lateinit var graph: Array<LinkedList<Int>>
private lateinit var dp: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    graph = Array(n + 1) { LinkedList<Int>() }
    val inDegree = IntArray(n + 1)
    dp = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        inDegree[b]++
        graph[a].add(b)
    }
    val queue = LinkedList<Int>()
    // 들어오는 차수가 0인애들 -> 선수과목이 없음
    for (i in 1 until inDegree.size) {
        if (inDegree[i] == 0) {
            queue.offer(i)
            // 1학기 내 이 수 가능
            dp[i] = 1
        }
    }
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        for (adj in graph[curr]) {
            if (--inDegree[adj] == 0) {
                queue.offer(adj)
            }
            // 다음 선수과목은 전의 과목 + 1
            dp[adj] = dp[curr] + 1
        }
    }
    for (i in 1 until dp.size) {
        print("${dp[i]} ")
    }
}