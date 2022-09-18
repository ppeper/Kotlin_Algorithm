package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    val people = readLine().split(' ').map { it.toInt() }
    val viewer = readLine().split(' ').map { it.toInt() }
    var total: Long = 0
    // 총 감독관 구하기
    for (i in 0 until size) {
        if (people[i] <= viewer[0]) {
            total += 1
            continue
        } else {
            total += if ((people[i] - viewer[0]) % viewer[1] == 0) {
                (people[i] - viewer[0]) / viewer[1] + 1
            } else {
                (people[i] - viewer[0]) / viewer[1] + 2
            }
        }
    }
    println(total)
}
