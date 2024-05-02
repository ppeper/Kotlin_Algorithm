package boj.Problem2623

import java.util.*

private lateinit var inDegree: IntArray
private lateinit var node: Array<LinkedList<Int>>
private var answer = ArrayList<Int>()
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    node = Array(n + 1) { LinkedList() }
    inDegree = IntArray(n + 1)
    repeat(m) {
        val input = readLine().split(" ").map { it.toInt() }
        for (i in 2 until input.size) {
            inDegree[input[i]]++
            node[input[i - 1]].add(input[i])
        }
    }
    val queue = LinkedList<Int>()
    for (i in 1..n) {
        if (inDegree[i] == 0) {
            queue.offer(i)
        }
    }
    while (queue.isNotEmpty()) {
        val target = queue.poll()
        answer.add(target)
        for (next in node[target]) {
            if (--inDegree[next] == 0) {
                queue.add(next)
            }
        }
    }
    if (answer.size != n) {
        println(0)
    } else {
        answer.forEach {
            println(it)
        }
    }
}