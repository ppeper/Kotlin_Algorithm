package programmers.level1

import java.util.*

class Crane {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()
        moves.forEach {
            for (i in board.indices) {
                // 가장 위의 인형 뽑기
                if (board[i][it - 1] != 0) {
                    // 인형의 짝이 맞으면 삭제
                    if (stack.isNotEmpty() && stack.peek() == board[i][it - 1]) {
                        answer += 2
                        stack.pop()
                    } else {
                        stack.push(board[i][it - 1])
                    }
                    // 뽑은 인형 초기화
                    board[i][it - 1] = 0
                    break
                }
            }
        }
        return answer
    }
}