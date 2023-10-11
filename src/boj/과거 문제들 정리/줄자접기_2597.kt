package boj.`과거 문제들 정리`

import kotlin.math.max

data class Dot(
    var position1: Float,
    var position2: Float
)
fun main(args: Array<String>) {
    var size = readln().toFloat()
    // 자의 시작위치
    var start = 0F
    // 빨, 파, 노 순서로 위치들 저장
    val list = mutableListOf<Dot>()
    var slicePosition = 0F
    // 색상들의 위치들 저장
    repeat(3) {
        val (pos1, pos2) = readln().split(' ').map { it.toFloat() }.sorted()
        list.add(Dot(pos1, pos2))
    }
    for (i in list.indices) {
        // 두 점이 만남
        if (list[i].position1 == list[i].position2) {
            continue
        }
        // 접히는 위치
        val slice = (list[i].position1 + list[i].position2) / 2
        // 접혔던 위치 저장
        slicePosition = max(slice, slicePosition)
        // 접히는 기준 왼쪽 오른쪽중 더 긴 길이가 자의 길이
        size = max(slicePosition - start,size - (slicePosition - start))
        start = slicePosition
        // 각 색깔의 입력이 주어질때 접으면서 다음 점들의 위치를 그에 맞에 바꿔준다
        for (j in i + 1 until list.size) {
            val dot = list[j]
            // 접히는 시점보다 뒤에 있다면 위치 변경
            if (dot.position1 < slicePosition) {
                dot.position1 += (slicePosition - dot.position1) * 2
            }
            if (dot.position2 < slicePosition) {
                dot.position2 += (slicePosition - dot.position2) * 2
            }
        }
    }
    println(size)
}