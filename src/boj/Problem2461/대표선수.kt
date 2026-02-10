package boj.Problem2461

import java.util.PriorityQueue

data class Student(
    val index: Int,
    val score: Int,
    val pointer: Int
): Comparable<Student> {
    override fun compareTo(other: Student): Int {
        return this.score - other.score
    }
}
private lateinit var pq: PriorityQueue<Student>
private lateinit var list: Array<List<Int>>
private var max = Int.MIN_VALUE
private var answer = Int.MAX_VALUE
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    list = Array(n) { readLine().split(" ").map { it.toInt() }.sorted() }
    pq = PriorityQueue()
    for (i in 0 until n) {
        pq.offer(Student(i, list[i][0], 0))
        max = maxOf(max, list[i][0])
    }
    while (true) {
        val (studentIndex, currentMin, pointer) = pq.poll()
        answer = minOf(answer, max - currentMin)

        if (pointer + 1 == m) break

        val nextPickScore = list[studentIndex][pointer + 1]
        pq.offer(Student(studentIndex, nextPickScore, pointer + 1))
        // 가장 큰 값 업데이트
        max = max.coerceAtLeast(nextPickScore)
    }
    println(answer)
}