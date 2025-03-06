package programmers.level2

class `서버 증설 횟수` {
    private lateinit var server: IntArray
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer = 0
        server = IntArray(players.size + k)
        for (index in players.indices) {
            if (players[index] < m) continue
            // 현재 시간대 필요한 서버의 수 - 현재 가지고 있는 서버
            val needServerCount = players[index] / m - server[index]
            if (0 < needServerCount) {
                buildServer(index, needServerCount, k)
                answer += needServerCount
            }
        }
        return answer
    }

    private fun buildServer(start: Int, serverCount: Int, k: Int) {
        for (index in start until start + k) {
            server[index] += serverCount
        }
    }
}

fun main() {
    val test = `서버 증설 횟수`()
    val players = intArrayOf(0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1)
    val m = 1
    val k = 1
    println(test.solution(players, m, k))
}