package programmers.level2

import java.util.PriorityQueue;
class `디펜스 게임` {
    private lateinit var pq: PriorityQueue<Int>
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        pq = PriorityQueue(reverseOrder())
        var remain = n
        var K = k

        for (i in enemy.indices) {
            pq.add(enemy[i])
            while (pq.isNotEmpty()) {
                if (K == 0) break
                if (enemy[i] <= remain) break
                K -= 1
                remain += pq.poll()
            }
            if (remain < enemy[i]) return i
            remain -= enemy[i]
        }
        return enemy.size
    }
}
