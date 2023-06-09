package programmers.kakao.KAKAO_BLIND_2023

class `KAKAO_BLIND_2023_개인정보 수집 유효기간` {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = ArrayList<Int>()
        val dDay = calculateHoleDays(today)
        val hm = HashMap<String, Int>()
        terms.forEach {
            val (term, month) = it.split(" ")
            hm[term] = month.toInt()
        }
        privacies.forEachIndexed { idx, privacy ->
            val (day, term) = privacy.split(" ")
            val holeDay = calculateHoleDays(day)
            val termDay = hm[term]!! * 28
            // 기한이 넘었다면 파기
            if (holeDay + termDay <= dDay) {
                answer.add(idx + 1)
            }
        }
        return answer.toIntArray()
    }

    // 파기해야할 날짜 일로 변환
    private fun calculateHoleDays(day: String): Int {
        val (year, month, day) = day.split(".")
        return year.toInt() * 12 * 28 + month.toInt() * 28 + day.toInt()
    }
}