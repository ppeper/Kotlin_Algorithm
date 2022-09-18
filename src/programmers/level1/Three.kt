package programmers.level1

class Three {
    fun solution(n: Int): Int {
        return n.toString(3).reversed().toInt(3)
    }
}