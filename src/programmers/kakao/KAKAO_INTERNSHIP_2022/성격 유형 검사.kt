package programmers.kakao.KAKAO_INTERNSHIP_2022

private val category = arrayOf("RT", "CF", "JM", "AN")
class `성격 유형 검사` {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer = ""
        val hm = HashMap<Char, Int>()
        hm.apply {
            put('R', 0)
            put('T', 0)
            put('C', 0)
            put('F', 0)
            put('J', 0)
            put('M', 0)
            put('A', 0)
            put('N', 0)
        }
        choices.forEachIndexed { idx, choice ->
            val front = survey[idx][0]
            val end = survey[idx][1]
            // i번 유형
            if (choice < 4) {
                hm[front] = hm.getOrDefault(front, 0) + 4 - choice
            } else {
                hm[end] = hm.getOrDefault(end, 0) + choice - 4
            }
        }
        // 점수별 유형 검사
        category.forEach { category ->
            val front = hm[category[0]]!!
            val end = hm[category[1]]!!
            answer += if (front == end) {
                category[0]
            } else if (front < end) {
                category[1]
            } else {
                category[0]
            }
        }
        return answer
    }
}