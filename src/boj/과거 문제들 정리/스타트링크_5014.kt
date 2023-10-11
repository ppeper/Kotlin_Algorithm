package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader

var button = Int.MAX_VALUE
private lateinit var visited: BooleanArray
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (F, S, G, U, D) = readLine().split(' ').map { it.toInt() }
    visited = BooleanArray(F + 1)
    arriveFloor(F, S, G, U, D, 0)
    if (button == Int.MAX_VALUE) {
        println("use the stairs")
    } else {
        println(button)
    }
}

private fun arriveFloor(f: Int, s: Int, g: Int, u: Int, d: Int, click: Int) {
    // 원하는 층에 도착
    if (s == g) {
        button = button.coerceAtMost(click)
        return
    }
    // 올라가야한다
    if (s < g) {
        // 위로 올라가는 버튼
        if (s + u <= f && u != 0 ) {
            visited[s + u] = true
            arriveFloor(f, s + u, g, u, d, click + 1)
        } else {
            // 내려가는 버튼
            if (0 < s - d && d != 0 && !visited[s - d]) {
                visited[s - d] = true
                arriveFloor(f, s - d, g, u, d, click + 1)
            }
        }
    } else {
        // 내려가는 버튼
        if (0 < s - d && d != 0 && !visited[s - d]) {
            visited[s - d] = true
            arriveFloor(f, s - d, g, u, d, click + 1)
        } else {
            if (s + u <= f && u != 0 && !visited[s + u]) {
                visited[s + u] = true
                arriveFloor(f, s + u, g, u, d, click + 1)
            }
        }
    }
}
