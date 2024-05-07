package boj.Problem3665

import java.util.*

private lateinit var inDegree: IntArray
private lateinit var graph: Array<LinkedList<Int>>
private var answer = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val testCase = readLine().toInt()
    repeat(testCase) {
        val n = readLine().toInt()
        inDegree = IntArray(n + 1)
        graph = Array(n + 1) { LinkedList() }
        val list = readLine().split(" ").map { it.toInt() }
        for (i in 0 until list.size - 1) {
            val from = list[i]
            for (j in i + 1 until list.size) {
                val to = list[j]
                graph[from].add(to)
                inDegree[to]++
            }
        }
        val m = readLine().toInt()
        repeat(m) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            if (graph[a].contains(b)) {
                graph[a].remove(b)
                graph[b].add(a)
                inDegree[a]++
                inDegree[b]--
            } else {
                graph[b].remove(a)
                graph[a].add(b)
                inDegree[b]++
                inDegree[a]--
            }
        }
        decideScore()
    }
    print(answer)
}

private fun decideScore() {
    val score = StringBuilder()
    val q = LinkedList<Int>()
    for (i in 1 until inDegree.size) {
        if (inDegree[i] == 0) q.add(i)
    }
    for (i in 1 until inDegree.size) {
        if (q.isEmpty()) {
            answer.append("IMPOSSIBLE\n")
            return
        }
        val size = q.size
        val flag = 1 < size
        for (j in 0 until size) {
            val curr = q.poll()
            if (flag) score.append("? ") else score.append("$curr ")
            for (next in graph[curr]) {
                if (--inDegree[next] == 0) {
                    q.add(next)
                }
            }
        }
    }
    answer.append("$score\n")
}
