package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    val result = ArrayList<String>()
    for (i in 0 until size) {
        val ps = readLine()
        var count = 0
        for (c in ps.toCharArray()) {
            if (c == '(') { count++ }
            if (c == ')') { count-- }
            if (count < 0) { break }
        }
        if (count == 0) {
            result.add("YES")
        } else {
            result.add("NO")
        }
    }
    for (re in result) {
        println(re)
    }
}
