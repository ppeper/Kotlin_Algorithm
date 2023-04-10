package programmers.kakao.KAKAO_BLIND_2021

class Solution {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        val playSec = convertSecond(play_time)
        // 광고 시간
        val advSec = convertSecond(adv_time)
        // 총 재생 시간
        val totalSec = LongArray(playSec + 1)
        for (time in logs) {
            val (start, end) = time.split("-")
            val startSec = convertSecond(start)
            val endSec = convertSecond(end)
            for (i in startSec until endSec) {
                totalSec[i]++
            }
        }
        // 초기 최대 광고 시간
        var currSum = 0L
        for (i in 0 until advSec) {
            currSum += totalSec[i]
        }
        // 값 구하기
        var maxSum = currSum
        var maxIdx = 0
        // 광고 구간마다의 시간 확인
        for (i in advSec until playSec) {
            currSum = currSum + totalSec[i] - totalSec[i - advSec]
            if (maxSum < currSum) {
                maxSum = currSum
                maxIdx = i - advSec + 1
            }
        }
        return String.format("%02d:%02d:%02d", maxIdx / 3600, maxIdx / 60 % 60, maxIdx % 60)
    }

    private fun convertSecond(time: String): Int {
        val input = time.split(":")
        return input[0].toInt() * 3600 + input[1].toInt() * 60 + input[2].toInt()
    }
}