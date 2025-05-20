package programmers.level2

import java.util.Stack

class  `뒤에 있는 큰 수 찾기` {
    private lateinit var stack: Stack<Int>
    fun solution(numbers: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        stack = Stack<Int>()
        for (index in numbers.size - 1 downTo 0) {
            val number = numbers[index]
            if (stack.isEmpty()) {
                answer.add(-1)
                stack.push(number)
                continue
            }
            while (stack.isNotEmpty()) {
                if (number < stack.peek()) {
                    answer.add(stack.peek())
                    stack.add(number)
                    break
                } else {
                    while (stack.isNotEmpty() && stack.peek() <= number) {
                        stack.pop()
                    }
                    if (stack.isNotEmpty()) {
                        answer.add(stack.peek())
                    } else {
                        answer.add(-1)
                    }
                    stack.push(number)
                    break
                }
            }

        }
        return answer.reversed().toIntArray()
    }
}