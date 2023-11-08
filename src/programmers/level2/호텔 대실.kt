package programmers.level2

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val checkTime = mutableListOf<MutableList<Int>>()
        val sortedBookTime = book_time.toList().sortedBy { it.first() }
        sortedBookTime.forEach {
            val start = it.first().split(":")[0].toInt() * 60 + it.first().split(":")[1].toInt()
            val end = it.last().split(":")[0].toInt() * 60 + it.last().split(":")[1].toInt() + 10
            val team = mutableListOf(start, end)
            if (checkTime.isEmpty()) {
                checkTime.add(team)
            } else {
                var check = true
                for (i in checkTime.indices) {
                    if (checkTime[i].last() <= start) {
                        check = false
                        checkTime[i].add(end)
                        break
                    }
                }
                if (check) {
                    checkTime.add(team)
                }
            }
        }
        return checkTime.size
    }
}