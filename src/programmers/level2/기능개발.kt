package programmers.level2

import java.util.*
import kotlin.math.*

class 기능개발 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue: Queue<Int> = LinkedList()
        val answer = mutableListOf<Int>()
        queue.add(getRemainDay(100 - progresses[0], speeds[0]))
        for (i in 1 until progresses.size) {
            val remain = getRemainDay(100 - progresses[i], speeds[i])
            if (remain <= queue.peek()) {
                queue.offer(remain)
            } else {
                answer.add(queue.size)
                queue.run {
                    clear()
                    add(remain)
                }
            }
        }
        answer.add(queue.size)
        return answer.toIntArray()
    }

    private fun getRemainDay(remainProgress: Int, speed: Int): Int {
        return ceil(remainProgress / speed.toDouble()).toInt()
    }
}