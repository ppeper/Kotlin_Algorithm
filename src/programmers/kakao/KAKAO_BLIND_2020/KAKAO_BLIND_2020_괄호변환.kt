package programmers.kakao.KAKAO_BLIND_2020

import java.util.*

class KAKAO_BLIND_2020_괄호변환 {
    fun solution(p: String): String {
        // p가 빈문자열이면 빈문자열 , 올바은 괄호면 올바른 괄호 리턴
        if (p == "" || isParenthesis(p)) {
            return p
        }
        return split(p)
    }

    // 균형잡힌 괄호 문자열 split
    private fun split(p: String): String {
        if (p == "") return p

        var u = ""
        var v = ""
        var index = 0
        var count = 0
        // 문자열 u, v로 나누기 index
        for (i in p) {
            if (i == '(') count++
            if (i == ')') count--
            index++
            if (count == 0) {
                u = p.substring(0, index)
                v = p.substring(index)
                break
            }
        }

        // 3 : 올바른 괄호 확인 -> 올바르면 올바른 문자열(u)에 v를 1단계부터 다시하여 붙임
        return if (isParenthesis(u)) {
            u + split(v)
        } else { // 4 : 올바른 괄호 x -> 빈 문자열에 '(' 에 문자열 v에 대해 1단계부터 다시하여 붙이고 ')'를 다시 붙임
            // 4-1, 4-2, 4-3
            val str = "(" + split(v) + ")"
            // 4-4 첫번째와 마지막 분자 제거후 나머지 문자열 괄호 방향 바꿈
            var str2 = ""
            u.substring(1,u.length-1).forEach {
                str2 = if (it=='(') "$str2)"
                else "$str2("
            }
            str + str2
        }
    }

    private fun isParenthesis(p: String): Boolean {
        return if (p[0] == ')') {
            false
        } else {
            val stack = Stack<Char>()
            for (ch in p.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch)
                } else {
                    if (stack.isEmpty()) {
                        return false
                    }
                    stack.pop()
                }
            }
            stack.isEmpty()
        }
    }
}