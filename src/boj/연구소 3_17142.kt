package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private lateinit var virus: ArrayList<Pair<Int, Int>>
private lateinit var board: Array<IntArray>
private lateinit var isVirus: BooleanArray
private var safeZone = 0
private var time = Int.MAX_VALUE
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(' ').map { it.toInt() }
    board = Array(N) { IntArray(N) }
    virus = ArrayList()
    for (i in 0 until N) {
        val input = readLine().split(' ').map { it.toInt() }
        for (j in input.indices) {
            if (input[j] == 2) {
                virus.add(Pair(i, j))
            }
            if (input[j] == 0) {
                safeZone++
            }
        }
        board[i] = input.toIntArray()
    }
    isVirus = BooleanArray(virus.size)
    if (safeZone != 0) {
        // 바이러스 선택
        setVirus(0, M)
        if (time == Int.MAX_VALUE) {
            println(-1)
        } else {
            println(time)
        }
    } else {
        println(0)
    }
}

private fun setVirus(start: Int, M: Int) {
    if (M == 0) {
        virusSpread()
        return
    }
    for (i in start until virus.size) {
        isVirus[i] = true
        setVirus(i + 1, M - 1)
        isVirus[i] = false
    }
}

private fun virusSpread() {
    var count = safeZone
    var spread = 0
    val visited = Array(board.size) { BooleanArray(board.size) }
    val q: Queue<Pair<Int, Int>> = LinkedList()
    for (i in isVirus.indices) {
        if (isVirus[i]) {
            q.offer(Pair(virus[i].first, virus[i].second))
        }
    }
    while (q.isNotEmpty()) {
        val size = q.size
        spread++
        for (i in 0 until size) {
            val curr = q.poll()
            visited[curr.first][curr.second] = true
            for (j in 0 until 4) {
                val cx = curr.first + dx[j]
                val cy = curr.second + dy[j]
                if (isValid(cx, cy)) {
                    if (!visited[cx][cy]) {
                        if (board[cx][cy] != 1) {
                            if (board[cx][cy] == 0) {
                                count--
                            }
                            visited[cx][cy] = true
                            q.offer(Pair(cx, cy))
                            // 안전지대 확인
                            if (count == 0) {
                                time = time.coerceAtMost(spread)
                                return
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun isValid(x: Int, y: Int): Boolean {
    return x in board.indices && y in board.indices
}
