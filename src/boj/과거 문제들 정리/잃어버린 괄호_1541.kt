package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    // - 기준으로 나눔
    val form = readLine().split("-".toRegex())
    var result = 0
    for (i in form.indices) {
        val plus = form[i].split("\\+".toRegex())
        for (num in plus) {
            if (i == 0) {
                result += num.toInt()
            } else {
                result -= num.toInt()
            }
        }
    }
    println(result)
}
