package boj.`과거 문제들 정리`

import kotlin.math.max

fun main() {
    val size = readln().toInt()
    val stair = Array(size + 1) { 0 }
    val score = Array(size + 1) { 0 }
    // 계단별 점수들 저장
    repeat(size) {
        stair[it + 1] = readln().toInt()
    }
    for (i in 1 until stair.size) {
        when (i) {
            1 -> score[i] = stair[1]
            2 -> score[i] = stair[i - 1] + stair[i]
            else -> {
                // 연속된 3계단은 못움직임 -> 2칸 전의 최대에서 현재 계단 vs 현재, 현재 - 1의 칸을 밟으니 현재 - 3까지의 최대의 합 비교
                score[i] = max(score[i - 2] + stair[i], score[i - 3] + stair[i - 1] + stair[i])
            }
        }
    }
    println(score[size])
}