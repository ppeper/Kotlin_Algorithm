package boj.bitmask

fun main() {
    val x = readln().toInt()
    // 1. 막대를 절반씩 자름 -> 비트 연산으로 2진법으로 1이 몇개있나 확인
    println(Integer.bitCount(x))
}