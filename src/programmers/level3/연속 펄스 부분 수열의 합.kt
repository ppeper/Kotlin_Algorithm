package programmers.level3

class `연속 펄스 부분 수열의 합` {
    fun solution(sequence: IntArray): Long {
        var answer = 0L
        var temp1 = 0L
        var temp2 = 0L
        val list1 = sequence.mapIndexed { index, i ->
            if (index % 2 == 0) i * -1 else i
        }
        val list2 = sequence.mapIndexed { index, i ->
            if (index % 2 == 1) i * -1 else i
        }
        for (i in sequence.indices) {
            temp1 += list1[i]
            temp2 += list2[i]
            if (temp1 < 0) temp1 = 0L
            if (temp2 < 0) temp2 = 0L
            answer = answer.coerceAtLeast(temp1)
                .coerceAtLeast(temp2)
        }
        return answer
    }
}