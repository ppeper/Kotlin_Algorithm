package level2

// 2021 카카오 채용연계형 인턴십 - 거리두기 확인하기

import java.util.*

data class Person(
    var x: Int,
    var y: Int,
    var distance: Int
)
class KeepDistance {
    private val dx = intArrayOf(-1, 0, 1, 0) // 좌우
    private val dy = intArrayOf(0, 1, 0, -1) // 상하
    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(places.size)
        for (i in places.indices) {
            answer[i] = bfs(places[i])
        }
        return answer
    }

    private fun bfs(place: Array<String>): Int {
        for (i in place.indices) {
            for (j in place[i].indices) {
                val queue: Queue<Person> = LinkedList()
                val visited = Array(place.size) { BooleanArray(place.size) }
                // 주변 확인할 인터뷰할 사람
                if (!visited[i][j] && place[i][j] == 'P') {
                    visited[i][j] = true
                    queue.offer(Person(i, j, 0))
                }
                while (queue.isNotEmpty()) {
                    val p = queue.poll()
                    // 거리가 2명 거리두기를 지키고 있음
                    if (p.distance == 2) {
                        continue
                    }
                    // 상하좌우\
                    for (k in 0 until 4) {
                        val x = p.x + dx[k]
                        val y = p.y + dy[k]
                        if (x in place.indices && y in place.indices) {
                            if (!visited[x][y]) {
                                // 위치마다 무엇이 있는지 확인
                                if (place[x][y] == 'P') {
                                    return 0
                                } else if (place[x][y] == 'O') {
                                    visited[x][y] = true
                                    queue.offer(Person(x, y, p.distance + 1))
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1
    }
}