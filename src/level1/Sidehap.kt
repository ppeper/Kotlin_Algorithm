package level1

class Sidehap {
    fun solution(a: Int, b: Int): Long {
        val answer: Long = if (a > b) {
            (b.toLong()..a.toLong()).sum()
        } else {
            (a.toLong()..b.toLong()).sum()
        }
        return answer
    }
}