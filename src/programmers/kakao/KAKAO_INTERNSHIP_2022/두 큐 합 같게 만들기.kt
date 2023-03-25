package programmers.kakao.KAKAO_INTERNSHIP_2022

import java.util.*

class `두 큐 합 같게 만들기` {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val depth = queue1.size + queue2.size
        val q1: Queue<Int> = LinkedList<Int>().apply {
            for (value in queue1) add(value)
        }
        val q2: Queue<Int> = LinkedList<Int>().apply {
            for (value in queue2) add(value)
        }
        var sum1 = q1.sum()
        var sum2 = q2.sum()
        if ((sum1 + sum2) % 2 == 0L) {
            var count1 = 0
            var count2 = 0
            var temp = 0
            // 최대 두 큐의 사이즈 * 2배까지 탐색
            while (count1 < depth * 2 && count2 < depth * 2) {
                if (sum1 == sum2) break
                if (sum1 < sum2) {
                    val out = q2.poll()
                    q1.offer(out)
                    sum1 += out
                    sum2 -= out
                    count2++
                } else {
                    val out = q1.poll()
                    q2.offer(out)
                    sum2 += out
                    sum1 -= out
                    count1++
                }
                temp++
            }
            return if (count1 != depth * 2) temp else -1
        } else {
            return -1
        }
    }
    private fun Queue<Int>.sum(): Long {
        var sum = 0L
        for (value in this) sum += value.toLong()
        return sum
    }
}