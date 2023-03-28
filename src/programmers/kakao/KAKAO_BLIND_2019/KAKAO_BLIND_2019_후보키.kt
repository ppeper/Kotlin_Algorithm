package programmers.kakao.KAKAO_BLIND_2019

// 2019 KAKAO BLIND RECRUITMENT - 후보키

class KAKAO_BLIND_2019_후보키 {
    var answer = 0
    private val list = ArrayList<String>()
    fun solution(relation: Array<Array<String>>): Int {
        val visited = BooleanArray(relation[0].size)
        // 가능한 조합을 다 따져준다
        for (i in 1..relation[0].size) {
            combination(visited, 0, i, "")
        }
        val uniqueList = ArrayList<String>()
        for (str in list) {
            // 조합중 후보기가 될 수 있는 조합만 결정
            if (isUnique(relation, str)) {
                if (!containValue(uniqueList, str)) {
                    uniqueList.add(str)
                }
            }
        }
        return uniqueList.size
    }

    private fun combination(visited: BooleanArray, start: Int, depth: Int, s: String) {
        if (depth == 0) {
            list.add(s)
            return
        }
        for (i in start until visited.size) {
            visited[i] = true
            combination(visited, i + 1, depth - 1, s + i)
            visited[i] = false
        }
    }

    // 유일성 만족하는지 확인
    private fun isUnique(relation: Array<Array<String>>, str: String): Boolean {
        // 처음 릴레이션과 크기가 같아야 유일성 만족
        val set = HashSet<String>()
        // 모든 행을 돌면서 조합에 따른 string을 set에 넣어줌
        for (i in relation.indices) {
            val concat = StringBuilder()
            for (c in str) {
                val index = Character.getNumericValue(c)
                concat.append(relation[i][index])
            }
            set.add(concat.toString())
        }
        return set.size == relation.size
    }

    private fun containValue(uniqueList: ArrayList<String>, value: String): Boolean {
        for (key in uniqueList) {
            var count = 0
            // 후보키에 있는 값들이 모두 value에 들어가있으면 최소성 X
            for (a in key) {
                if (value.contains(a)) {
                    count++
                }
            }
            if (count == key.length) {
                return true
            }
        }
        return false
    }
}