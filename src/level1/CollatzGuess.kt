package level1

class CollatzGuess {
    fun solution(num: Int): Int {
        var number = num.toLong()
        var answer = 0
        while (number != 1L) {
            when (number % 2L) {
                0L -> number /= 2
                1L -> number = number * 3 + 1
            }
            answer++
            if (answer >= 500) {
                answer = -1
                break
            }
        }
        return answer
    }
}