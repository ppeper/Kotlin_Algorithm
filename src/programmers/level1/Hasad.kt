package programmers.level1

class Hasad {
    fun solution(x: Int): Boolean {
        val sum = x.toString().map {
            it.toString().toInt()
        }.sum()
        return x % sum == 0
    }
}