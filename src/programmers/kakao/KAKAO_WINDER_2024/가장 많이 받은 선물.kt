package programmers.kakao.KAKAO_WINDER_2024

class `가장 많이 받은 선물` {
    private lateinit var giftRate: HashMap<String, Int>
    private lateinit var graph: Array<IntArray>
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        graph = Array(friends.size) { IntArray(friends.size) }
        val count = IntArray(graph.size)
        giftRate = HashMap()
        friends.forEach { giftRate[it] = 0 }
        gifts.forEach { gift ->
            val (from, to) = gift.split(" ")
            giftRate[from] = giftRate.getOrDefault(from, 0) + 1
            giftRate[to] = giftRate.getOrDefault(to, 0) - 1
            // 선물 주고 받은 기록
            val indexFrom = friends.indexOf(from)
            val indexTo = friends.indexOf(to)
            graph[indexFrom][indexTo]++
        }
        for (i in graph.indices) {
            for (j in i + 1 until graph.size) {
                val giftFromMe = graph[i][j]
                val giftFromOther = graph[j][i]

                if (giftFromMe == giftFromOther) {
                    val fromUser = giftRate[friends[i]]!!
                    val toUser = giftRate[friends[j]]!!
                    if (fromUser < toUser) {
                        count[j]++
                    } else if (toUser < fromUser) {
                        count[i]++
                    }
                } else {
                    if (giftFromMe < giftFromOther) {
                        count[j]++
                    } else {
                        count[i]++
                    }
                }
            }
        }
        return count.maxOrNull() ?: 0
    }
}