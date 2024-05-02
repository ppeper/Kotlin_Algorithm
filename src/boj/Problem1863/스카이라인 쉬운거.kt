package boj.Problem1863

import java.util.Stack

private lateinit var stack: Stack<Int>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var answer = 0
    stack = Stack<Int>()
    for (i in 0 until n) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        if (stack.isEmpty()) {
            stack.push(y)
            continue
        }
        // 건물이 작아진다 -> 하나의 건물이 생성
        while (stack.isNotEmpty() && y < stack.peek()) {
            answer++
            stack.pop()
        }
        if (stack.isNotEmpty() && stack.peek() == y) continue
        stack.push(y)
    }
    while (stack.isNotEmpty()) {
        if (0 < stack.peek()) answer++
        stack.pop()
    }
    println(answer)
}