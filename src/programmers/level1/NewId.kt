package programmers.level1

class NewId {
    fun solution(new_id: String): String {
        var answer = ""
        new_id.lowercase().filter {
            it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.'
        }.replace("[.]*[.]".toRegex(), ".").removePrefix(".").removeSuffix(".")
            .let {
                if (it.isEmpty()) {
                    answer = "a"
                } else {
                    answer = it
                }
                if (answer.length > 15) {
                    answer = it.substring(0,15).removeSuffix(".")
                } else if (answer.length <= 2) {
                    val last = answer.last()
                    while (answer.length < 3) {
                        answer += last
                    }
                } else {
                    answer
                }
            }
        return answer
    }
}