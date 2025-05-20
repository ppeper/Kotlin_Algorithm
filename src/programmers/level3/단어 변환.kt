package programmers.level3

class `단어 변환` {
    private var answer = Int.MAX_VALUE
    fun solution(begin: String, target: String, words: Array<String>): Int {
        if (!words.contains(target)) return 0
        dfs(begin, target, words.toMutableSet(), 0)
        return answer
    }

    private fun dfs(begin: String, target: String, words: Set<String>, count: Int) {
        if (begin == target) {
            answer = answer.coerceAtMost(count)
            return
        }
        for (word in words) {
            if (checkWord(begin, word)) {
                dfs(word, target, words - word, count + 1)
            }
        }
    }

    private fun checkWord(source: String, target: String): Boolean {
        return source.toList().intersect(target.toList()).count() == source.length - 1
    }
}