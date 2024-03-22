package programmers.level3

import java.util.Stack

const val WORD = "110"

class `110 옮기기` {
    fun solution(s: Array<String>): Array<String> {
        val answer = Array(s.size) { "" }
        s.forEachIndexed { i, string ->
            if (string.length < 3) {
                answer[i] = string
            } else {
                answer[i] = makeWord(string)
            }
        }
        return answer
    }

    private fun makeWord(string: String): String {
        val stack = Stack<Char>()
        var count = 0 // 110 확인
        for (i in string.indices) {
            if (stack.size < 2)  {
                stack.push(string[i])
                continue
            }
            // 110의 여부 확인
            if (string[i] == '0') {
                val c = stack.pop()
                if (c == '1' && stack.peek() == '1') {
                    stack.pop()
                    count++
                    continue
                }
                stack.push(c)
            }
            stack.push(string[i])
        }
        val list = stack.toList()
        val sb = StringBuilder()
        // 마지막 0위치 찾기
        val pos = list.lastIndexOf('0')
        if (pos == -1) {
            repeat(count) {
                sb.append(WORD)
            }
            sb.append(list.joinToString(""))
        } else {
            for (i in 0..pos) {
                sb.append(list[i])
            }
            repeat(count) {
                sb.append(WORD)
            }
            for (i in pos + 1 until list.size) {
                sb.append(list[i])
            }
        }
        return sb.toString()
    }
}