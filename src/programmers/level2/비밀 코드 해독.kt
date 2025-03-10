package programmers.level2

class `비밀 코드 해독` {
    private lateinit var pick: IntArray
    private lateinit var list: Array<IntArray>
    private lateinit var match: IntArray
    private var answer = 0
    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        pick = IntArray(5)
        match = ans
        list = q
        makeNumber(0, 1, n)
        return answer
    }

    private fun makeNumber(depth: Int, start: Int, n: Int) {
        if (depth == 5) {
            // 가능 여부 확인
            if (checkNumber()) answer++
            return
        }
        for (i in start..n) {
            pick[depth] = i
            makeNumber(depth + 1, i + 1, n)
        }
    }

    private fun checkNumber(): Boolean {
        for (i in match.indices) {
            val matchNumber = match[i]
            val target = list[i]
            if ((target.subtract(pick.toSet())).size != 5 - matchNumber) {
                return false
            }
        }
        return true
    }
}
