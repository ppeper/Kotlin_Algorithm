package boj.Problem9935

import kotlin.collections.ArrayDeque

fun main() = with(System.`in`.bufferedReader()) {
    val deque = ArrayDeque<Char>()
    val input = readLine()
    val target = readLine()

    for (alpha in input) {
        deque.add(alpha)

        // 폭팔 문자열 확인
        if (target.length <= deque.size) {
            var flag = true

            for (i in target.indices) {
                if (deque[deque.size - target.length + i] != target[i]) {
                    flag = false
                    break
                }
            }
            if (flag) {
                repeat(target.length) { deque.removeLast() }
            }
        }
    }
    if (deque.isEmpty()) println("FRULA") else println(deque.joinToString(""))
}

