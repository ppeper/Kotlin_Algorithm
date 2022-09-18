package programmers.level1

class decend {
    fun solution(s: String): String {
        return s.toCharArray()
            .sortedDescending()
            .joinToString("")
    }
}