package level3

import kotlin.math.min

class WordChange {
    var answer = Integer.MAX_VALUE
    fun solution(begin: String, target: String, words: Array<String>): Int {
        // target 단어를 포함하고 있지 않다면 0
        return if (!words.contains(target)) {
            0
        } else {
            dfs(begin, target, words.toMutableList(), 0)
        }
    }

    private fun dfs(begin: String, target: String, words: MutableList<String>, count: Int): Int {
        if (begin == target) {
            if (count != 0) {
                answer = min(answer, count)
            }
            return answer
        } else {
            // 바꿀수 있음 단어 리스트
            val list = words.filter {
                checkWord(begin, it)
            }
            list.forEach {
                dfs(it, target, (words - it) as MutableList<String>, count + 1)
            }
        }
        return answer
    }

    private fun checkWord(word: String, target: String): Boolean {
        var check = 0
        word.indices.forEach {
            // 다른 단어가 2개 이상이면 false 리턴
            if (check > 1) {
                return false
            }
            // 단어가 다르면 check 추가
            if (word[it] != target[it]) {
                check++
            }
        }
        return check == 1
    }
}