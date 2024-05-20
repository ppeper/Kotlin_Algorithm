package programmers.level3

class `보석 쇼핑` {
    fun solution(gems: Array<String>): IntArray {
        val answer = intArrayOf(1, gems.size)
        val map = HashMap<String, Int>()
        val maxSize = gems.distinct().size // 서로다른 보석 개수
        var left = 0
        var right = 0

        while (left <= right && right < gems.size) {
            map[gems[right]] = map.getOrDefault(gems[right], 0) + 1
            right++

            while (map.size == maxSize) {
                map[gems[left]] = map[gems[left]]!! - 1
                if (map[gems[left]] == 0) {
                    map.remove(gems[left])
                }
                left++
                if (right - left < answer[1] - answer[0]) {
                    answer[0] = left
                    answer[1] = right
                }
            }
        }
        return answer
    }
}