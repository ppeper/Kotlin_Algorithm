package level1

class Kim {
    fun solution(seoul: Array<String>): String {
        var answer = ""
        seoul.forEachIndexed { index, s ->
            if (s == "Kim") {
                answer = "김서방은 ${index}에 있다"
            }
        }
        return answer
    }
}