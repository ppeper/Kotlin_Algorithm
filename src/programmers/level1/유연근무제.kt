package programmers.level1

class 유연근무제 {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer = 0
        val weekend = setOf(6, 7)
        for (i in schedules.indices) {
            val targetTime = schedules[i].asTime() + 10
            var allPass = true
            val timelog = timelogs[i]
            for (j in timelog.indices) {
                val day = if (8 <= j + startday) (j + startday) % 8 + 1 else j + startday
                if (weekend.contains(day)) continue
                if (targetTime < timelog[j].asTime()) {
                    allPass = false
                    break
                }
            }
            if (allPass) answer++
        }
        return answer
    }

    private fun Int.asTime(): Int {
        val hour = this / 100
        val min = this % 100
        return hour * 60 + min
    }
}