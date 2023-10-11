package boj.`과거 문제들 정리`

import java.util.PriorityQueue

fun main() {
    val count = readln().toInt()
    val pq = PriorityQueue<Int>(compareBy { it })
    val answer = ArrayList<Int>()
    for (i in 0 until count) {
        val number = readln().toInt()
        if (number == 0) {
            if (pq.isEmpty()) {
                answer.add(0)
            } else {
                answer.add(pq.poll())
            }
        } else {
            pq.add(number)
        }
    }
    answer.forEach {
        println(it)
    }
}