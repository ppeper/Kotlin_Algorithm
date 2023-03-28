package programmers.kakao.KAKAO_BLIND_2019

import java.util.*

// 2019 KAKAO BLIND RECRUITMENT

class KAKAO_BLIND_2019_오픈채팅방 {
    fun solution(record: Array<String>): Array<String> {
        val map = HashMap<String, String>()
        record.forEach { re ->
            val split = re.split(" ")
            if (split[0] == "Enter" || split[0] == "Change") {
                map[split[1]] = split[2]
            }
        }
        return record.filter {
            it.split(" ")[0] != "Change"
        }.map { re ->
            val split = re.split(" ")
            if (split[0] == "Enter") {
                map[split[1]] + "님이 들어왔습니다."
            } else {
                map[split[1]] + "님이 나갔습니다."
            }
        }.toTypedArray()
    }
}