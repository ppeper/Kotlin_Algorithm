package programmers.level2

import java.util.*

class 택배상자 {
    fun solution(order: IntArray): Int {
        var answer = 0
        val assistBelt = Stack<Int>()
        var box = 1
        for (ord in order) {
            while (box <= order.size) {
                // 메인 컨테이너에 맞는 박스를 찾음
                if (box == ord) break
                else if (assistBelt.isNotEmpty() && assistBelt.peek() == ord) {
                    break
                } else {
                    assistBelt.push(box++)
                }
            }
            if (box == ord) {
                box++
                answer++
            } else if (assistBelt.isNotEmpty() && assistBelt.peek() == ord) {
                assistBelt.pop()
                answer++
            } else {
                break
            }
        }
        return answer
    }
}