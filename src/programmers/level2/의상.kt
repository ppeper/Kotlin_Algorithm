package programmers.level2

class 의상 {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map = clothes.groupBy { it[1] }
        map.values.forEach { answer *= (it.size + 1)  }
        return answer - 1
    }
}

fun main() {
    val s = 의상()
    val clothes = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear"),
    )
    println(s.solution(clothes))
}