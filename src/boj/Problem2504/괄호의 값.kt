package boj.Problem2504

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val stack = Stack<Char>()
    val input = readLine()
    var answer = 0
    var buffer = 1
    for ((i, ch) in input.withIndex()) {
        when (ch) {
            '(' -> {
                stack.push(ch)
                buffer *= 2
            }
            '[' -> {
                stack.push(ch)
                buffer *= 3
            }
            ')' -> {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0
                    break
                }
                if (input[i - 1] == '(') {
                    answer += buffer
                }
                stack.pop()
                buffer /= 2
            }
            ']' -> {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0
                    break
                }
                if (input[i - 1] == '[') {
                    answer += buffer
                }
                stack.pop()
                buffer /= 3
            }
        }
    }
    if (stack.isEmpty()) println(answer) else println(0)
}