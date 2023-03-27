package programmers.kakao.KAKAO_BLIND_2022

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.ceil

class KAKAO_BLIND_2022_주차요금계산 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val hm = HashMap<String, Int>()
        val result = TreeMap<String, Int>()
        records.forEach { record ->
            val (time, number, state) = record.split(" ")
            val minute = calculateTime(time)
            if (state == "IN") {
                hm[number] = minute
                if (!result.containsKey(number)) {
                    result[number] = 0
                }
            } else {
                // out
                result[number] = result.getOrDefault(number, 0) + calculateTime(time) - hm[number]!!
                hm.remove(number)
            }
        }
        // 출차를 안한경우 -> 23:59분으로 나간것으로 처리
        hm.forEach { (key, value) ->
            result[key] = result.getOrDefault(key, 0) + 23 * 60 + 59 - value
        }
        val answer = IntArray(result.size)
        for ((idx, value) in result.values.withIndex()) {
            answer[idx] = fees[1]
            if (value > fees[0]) {
                answer[idx] += (ceil((value - fees[0]) / fees[2].toDouble()) * fees[3]).toInt()
            }
        }
        return answer
    }

    private fun calculateTime(time: String): Int {
        val (hour, minute) = time.split(":")
        return hour.toInt() * 60 + minute.toInt()
    }
}

fun main() {
    val test = KAKAO_BLIND_2022_주차요금계산()
    val fees = intArrayOf(180, 5000, 10, 600)
    val records = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")
    println(test.solution(fees, records).toList())
}