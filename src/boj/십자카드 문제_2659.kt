package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(' ')
    var number = ""
    for (i in input.indices) {
        number += input[i]
    }
    val minNumber = getMinNumber(number.toInt())
    var answer = 0
    for (k in 1111..minNumber) {
        if (getMinNumber(k) == k) answer++
    }
    println(answer)
}

private fun getMinNumber(number: Int): Int {
    var min = number
    // 돌아가면서 시계수를 구해준다
    for (start in 1 until number.toString().length) {
        val buffer = StringBuffer()
        for (i in start until number.toString().length) {
            buffer.append(number.toString()[i])
        }
        for (j in 0 until start) {
            buffer.append(number.toString()[j])
        }
        min = min.coerceAtMost(buffer.toString().toInt())
    }
    return min
}