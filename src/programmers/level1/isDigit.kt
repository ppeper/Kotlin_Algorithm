package programmers.level1

class isDigit {
    fun solution(s: String): Boolean {
        return s.all { it.isDigit() && (s.length == 4 || s.length == 6) }
    }
}