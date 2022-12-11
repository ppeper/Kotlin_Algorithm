package boj

import java.lang.StringBuilder
import java.util.LinkedList

private lateinit var list: Array<LinkedList<Int>>
fun main() {
    val input = readln().toInt()
    list = Array(input) { LinkedList() }
    repeat(input - 1) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        list[a - 1].add(b - 1)
        list[b - 1].add(a - 1)
    }
    val test = readln().toInt()
    val answer = StringBuilder()
    for (i in 0 until test) {
        val (t, k) = readLine()!!.split(' ').map { it.toInt() }
        when (t) {
            1 -> {
                if (1 < list[k - 1].size) answer.append("yes\n") else answer.append("no\n")
            }
            2 -> { answer.append("yes\n") }
        }
    }
    println(answer)
}
