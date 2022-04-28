package practice

class test3 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var A = a
        var B = b
        var answer = 0
        while (!check(A, B)) {
            if (A % 2 == 0) {
                A /= 2
            } else {
                A = (A + 1) / 2
            }
            if (B % 2 == 0) {
                B /= 2
            } else {
                B = (B + 1) / 2
            }
            answer++
        }

        return answer + 1
    }

    fun check(a: Int, b: Int): Boolean {
        return if (a < b) {
            (a + 1) == b
        } else {
            a == (b + 1)
        }
    }
}

fun main() {
    val t = test3()
    t.solution(8, 4, 7)
}