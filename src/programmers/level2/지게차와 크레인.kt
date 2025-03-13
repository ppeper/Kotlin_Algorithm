package programmers.level2

class `지게차와 크레인` {
    private lateinit var storages: Array<CharArray>
    private lateinit var visited: Array<BooleanArray>
    private val dx = intArrayOf(1, -1, 0, 0)
    private val dy = intArrayOf(0, 0, 1, -1)
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        storages = storage.map { it.toCharArray() }.toTypedArray()
        visited = Array(storage.size) { BooleanArray(storage[0].length) }
        requests.forEach { request ->
            if (request.length == 2) {
                runCrane(request[0])
            } else {
                visited = Array(storage.size) { BooleanArray(storage[0].length) }
                for (i in storages.indices) {
                    for (j in storages[0].indices) {
                        if (visited[i][j]) continue
                        if (i == 0 || j == 0 || i == storages.size - 1 || j == storages[0].size - 1) {
                            if (storages[i][j] != request[0] && storages[i][j] != '.') continue
                            runCar(i, j, request[0])
                        }
                    }
                }
            }
        }
        return storages.sumOf { stor -> stor.count { it != '.'} }
    }

    private fun runCrane(request: Char) {
        for (i in storages.indices) {
            for (j in storages[0].indices) {
                if (storages[i][j] == request) {
                    storages[i][j] = '.'
                }
            }
        }
    }

    private fun runCar(i: Int, j: Int, request: Char) {
        if (i !in storages.indices || j !in storages[0].indices) return
        if (visited[i][j]) return
        visited[i][j] = true
        if (storages[i][j] == request) {
            storages[i][j] = '.'
            return
        }
        if (storages[i][j] != '.') return
        for (d in 0 until 4) {
            val nx = i + dx[d]
            val ny = j + dy[d]
            runCar(nx, ny, request)
        }
    }
}

