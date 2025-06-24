package programmers.level2

import java.util.*

data class Work(
    val name: String,
    val start: String,
    val playtime: Int
)

class `과제 진행하기` {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val finish = mutableListOf<String>()
        val works = Stack<Work>()
        var currentTime = 0
        plans.sortedBy { it[1] }.forEach { (name, start, playtime) ->
            while (works.isNotEmpty() && currentTime < start.asTime()) {
                val work = works.pop()
                val endWorkTime = work.playtime + currentTime
                // 멈춰둔 과제를 다음 과제 시작 전에 끝냄
                if (endWorkTime <= start.asTime()) {
                    finish.add(work.name)
                    currentTime = endWorkTime
                } else {
                    // 과제를 조금 진행함(업데이트)
                    works.add(work.copy(playtime = endWorkTime - start.asTime()))
                    currentTime = start.asTime()
                    break
                }
            }
            works.add(Work(name, start, playtime.toInt()))
            currentTime = start.asTime()
        }
        while (works.isNotEmpty()) finish.add(works.pop().name)
        return finish.toTypedArray()
    }

    private fun String.asTime(): Int {
        val split = this.split(":").map { it.toInt() }
        return split[0] * 60 + split[1]
    }
}