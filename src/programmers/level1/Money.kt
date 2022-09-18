package programmers.level1

class Money {
    fun solution(price: Int, money: Int, count: Int): Long {
        val answer: Long
        var total: Long = 0
        // 탄 횟수별로 가격 정하기
        for (i in 1..count) {
            total += price.toLong() * i
        }
        answer = total - money
        return if (answer < 0) 0 else answer
    }
}