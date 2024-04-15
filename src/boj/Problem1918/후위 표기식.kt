package boj.Problem1918

import java.util.*

private lateinit var stack: Stack<Char>
private var postFix = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    stack = Stack()
    val input = readLine()
    convertPostFix(input)
    println(postFix.toString())
}

private fun convertPostFix(input: String) {
    input.forEach { c ->
        if (c.isLetter()) postFix.append(c)
        else if (c == '(') {
            stack.push(c)
        } else if (c == ')') {
            while (stack.isNotEmpty() && stack.peek() != '(') {
                postFix.append(stack.pop())
            }
            stack.pop()
        } else {
            // 우선 순위 확인
            if (c == '-' || c == '+') {
                while (stack.isNotEmpty() && stack.peek() != '(') {
                    postFix.append(stack.pop())
                }
            } else {
                while (stack.isNotEmpty() && stack.peek() != '(' && stack.peek() != '-' && stack.peek() != '+') {
                    postFix.append(stack.pop())
                }
            }
            stack.push(c)
        }
    }
    while (stack.isNotEmpty()) {
        postFix.append(stack.pop())
    }
}