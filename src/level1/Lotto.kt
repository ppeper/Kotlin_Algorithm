package level1

class Lotto {
    fun solution(lottos: IntArray, winNums: IntArray): IntArray {
        return intArrayOf (
            // 가장 많이 맞을수 있는 개수
            lottos.filter { winNums.contains(it) || it == 0 }.size,
            // 가장 적게 맞을수 있는 개수
            lottos.filter { winNums.contains(it) }.size
        ).map { if (it < 2 ) 6 else 7 - it  }.toIntArray()
    }
}