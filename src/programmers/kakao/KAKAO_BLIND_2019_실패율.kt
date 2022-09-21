package programmers.kakao

class KAKAO_BLIND_2019_실패율 {
    fun solution(N: Int, stages: IntArray): IntArray {
        val map = (1..N).map{ stage ->
            val total = stages.count { stage <= it }
            val fail = stages.count { it == stage }
            if (total != 0) stage to fail / total.toFloat() else stage to 0.0F
        }.toMap()
        return map.toList().sortedWith(
            compareByDescending { it.second }
        ).map { it.first }.toIntArray()
    }
}