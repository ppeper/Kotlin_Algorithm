package programmers.kakao

class KAKAO_BLIND_2021_메뉴리뉴얼 {
    private val menuList = ArrayList<String>()
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = ArrayList<String>()
        for (order in orders) {
            for (i in course) {
                if (i <= order.length) {
                    val visited = BooleanArray(order.length)
                    // 알파벳 순으로 오름차순 정렬
                    val list = order.toCharArray().sorted()
                    courseMenu(list, visited, 0, i, "")
                }
            }
        }
        // 메뉴의 개수에 따른 추가 코스요리
        val map = menuList.groupingBy { it }.eachCount().toList().groupBy { it.first.length }
        for (i in course) {
            val list = map[i]
            val max = list?.maxOf { it.second } ?: 0
            list?.forEach {
                if (it.second > 1 && it.second == max) {
                    answer.add(it.first)
                }
            }
        }
        return answer.sorted().toTypedArray()
    }

    private fun courseMenu(list: List<Char>, visited: BooleanArray, start: Int, depth: Int, menu: String) {
        if (depth == 0) {
            menuList.add(menu)
            return
        }
        for (i in start until visited.size) {
            visited[i] = true
            courseMenu(list, visited, i + 1, depth - 1, menu + list[i])
            visited[i] = false
        }
    }
}