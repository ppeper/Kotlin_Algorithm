package boj.Problem11286

import java.util.PriorityQueue
import kotlin.math.abs

data class Node(
    val number: Int,
    val absNumber: Int
): Comparable<Node> {
    override fun compareTo(other: Node): Int {
        if (other.absNumber == this.absNumber) {
            return this.number - other.number
        }
        return this.absNumber - other.absNumber
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val answer = StringBuilder()
    val pq = PriorityQueue<Node>()
    repeat(n) {
        val number = readLine().toInt()
        if (number != 0) {
            val absNumber = abs(number)
            pq.add(Node(number, absNumber))
        } else {
            pq.poll()?.let { (number, _) ->
                answer.append("$number\n")
            } ?: answer.append("0\n")
        }
    }
    println(answer)
}