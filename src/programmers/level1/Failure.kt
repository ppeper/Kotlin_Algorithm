package programmers.level1

data class Stage(
    var stage: Int,
    var failure: Float
)

class Failure {
    fun solution(N: Int, stages: IntArray): IntArray {
        val answer = Array(N) { Stage(it + 1, 0.0F) }
        for (stage in 1..N) {
            val total = stages.count {
                it >= stage
            }
            var success = 0
            for (i in stages) {
                if (i > stage) {
                    success++
                }
            }
            if (total != 0) answer[stage - 1].failure = ((total - success).toFloat() / total.toFloat())
        }
        answer.sortWith(
            compareByDescending<Stage> { it.failure }.thenBy { it.stage }
        )
        return answer.map { it.stage }.toIntArray()
    }
}