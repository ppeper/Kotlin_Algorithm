package programmers.level2

import java.util.Stack

private val openList = charArrayOf('(', '{', '[')
class `괄호 회전하기` {
    fun solution(s: String): Int {
        return s.indices.count { isValid(s.substring(it, s.length) + s.substring(0, it))}
    }

    private fun isValid(target: String): Boolean {
        val stack = Stack<Char>()
        for (c in target) {
            if (c.isOpen()) {
                stack.push(c)
                continue
            }
            if (stack.isEmpty()) return false
            val peek = stack.peek()
            if((c == ')')  && (peek == '(')) stack.pop()
            else if((c == '}')  && (peek == '{')) stack.pop()
            else if((c == ']')  && (peek == '[')) stack.pop()
        }
        return stack.isEmpty()
    }

    private fun Char.isOpen(): Boolean {
        return openList.contains(this)
    }
}