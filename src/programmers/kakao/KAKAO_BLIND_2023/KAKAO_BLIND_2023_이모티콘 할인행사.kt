package programmers.kakao.KAKAO_BLIND_2023

class Solution {
    private val answer = IntArray(2)
    private val RATE = intArrayOf(10, 20, 30, 40)
    private lateinit var pick: IntArray

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        pick = IntArray(emoticons.size)
        // 중복조합으로 모든 이모티콘에 대해서 모든 할인율 구하기
        emoticons_sales_rate(0, emoticons.size, users, emoticons)
        return answer
    }

    private fun emoticons_sales_rate(cnt: Int, r: Int, users: Array<IntArray>, emoticons: IntArray) {
        if (cnt == r) {
            // 할인율에 따른 result 계산
            calculate(users, emoticons)
            return
        }
        for (i in RATE.indices) {
            pick[cnt] = RATE[i]
            emoticons_sales_rate(cnt + 1, r, users, emoticons)
        }
    }

    private fun calculate(users: Array<IntArray>, emoticons: IntArray) {
        var plusUsers = 0
        var totalSum = 0
        users.forEach { user ->
            var sum = 0
            val (rate, overPrice) = user
            // 이모티콘 계산
            emoticons.forEachIndexed { idx, emoticon ->
                if (rate <= pick[idx]) {
                    val price = emoticon * (100 - pick[idx]) / 100
                    sum += price
                }
            }
            // 이모티콘 플러스 가입 여부 확인
            if (overPrice <= sum) {
                plusUsers++
            } else {
                totalSum += sum
            }
        }
        if (answer[0] == plusUsers) {
            // 가장 많은 판매액으로 업데이트
            answer[1] = answer[1].coerceAtLeast(totalSum)
        } else if (answer[0] < plusUsers) {
            answer[0] = plusUsers
            answer[1] = totalSum
        }
    }
}

fun main() {
    val s = Solution()
    val user = arrayOf(intArrayOf(40, 10000), intArrayOf(25, 10000))
    val emoticons = intArrayOf(7000, 9000)
    println(s.solution(user,emoticons).toList())
}