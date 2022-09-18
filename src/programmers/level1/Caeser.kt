package programmers.level1

class Caeser {
    fun solution(s: String, n: Int): String {
        return s.toList().joinToString("") {
            when (it) {
                in 'A'..'Z' -> {
                    if (it + n > 'Z') {
                        it + n - 26
                    } else {
                        it + n
                    }
                }
                in 'a'..'z' -> {
                    if (it + n > 'z') {
                        it + n - 26
                    } else {
                        it + n
                    }
                }
                else -> it
            }.toString()
        }
    }
}