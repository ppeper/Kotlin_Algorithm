package programmers.level1

class `택배 상자 꺼내기` {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer = 0
        var targetIndex = -1

        val list = (1..n)
            .chunked(w)
            .map { if (it.size < w) it + List(w - it.size) { 0 } else it }
            .mapIndexed { index, list ->
                if (index % 2 == 0) list else list.reversed()
            }
        for (i in list.indices) {
            for (j in list[0].indices) {
                if (list[i][j] == num) targetIndex = j
                if (targetIndex != -1 && list[i][j] != 0 && j == targetIndex) answer++
            }
        }
        return answer
    }
}
