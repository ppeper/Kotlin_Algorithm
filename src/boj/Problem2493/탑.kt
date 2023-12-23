package boj.Problem2493

import java.util.*

data class Node(
    val i: Int,
    val height: Int
)
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stack = Stack<Node>()
    val answer = ArrayList<Int>()
    val list = readLine().split(" ").mapIndexed { index, s -> Node(index, s.toInt())  }
    for (i in 0 until n) {
        val curr = list[i]
        if (stack.isEmpty()) {
            answer.add(0)
            stack.push(curr)
        } else {
            while (true) {
                if (stack.isEmpty()) {
                    answer.add(0)
                    stack.push(curr)
                    break
                }
                if (curr.height < stack.peek().height) {
                    answer.add(stack.peek().i + 1)
                    stack.push(curr)
                    break
                } else {
                    stack.pop()
                }
            }
        }
    }
    println(answer.joinToString(" "))
}