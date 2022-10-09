package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Belt (
    var onRobot: Boolean,
    var durability: Int
)
private var N = 0
private var step = 0
private lateinit var containerBelt: LinkedList<Belt>
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val (n, K) = readLine().split(' ').map { it.toInt() }
    N = n
    containerBelt = LinkedList()
    val input = readLine().split(' ').map { it.toInt() }
    // 기본 벨트의 상태 세팅
    for (i in input.indices) {
        containerBelt.offer(Belt(false, input[i]))
    }
    // 머신 동작
    machineExecute(K)
    println(step)
}

private fun machineExecute(K: Int) {
    while (true) {
        step++
        // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
        containerBelt.addFirst(containerBelt.pollLast())
        // 로봇 내리기
        containerBelt[N - 1].onRobot = false
        // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
        // -> 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
        moveRobot()
        // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
        if (!containerBelt[0].onRobot && 0 < containerBelt[0].durability) {
            containerBelt[0].onRobot = true
            containerBelt[0].durability -= 1
        }
        if (K <= containerBelt.count { it.durability == 0 }) {
            return
        }
    }
}

private fun moveRobot() {
    // 올라가있는 로봇 찾기
    val list = LinkedList<Int>()
    for (i in N - 1 downTo 0) {
        // 로봇이 있을때 동작
        if (containerBelt[i].onRobot) {
            list.offer(i)
        }
    }
    while (list.isNotEmpty()) {
        val curr = list.poll()
        val movePosition = curr + 1
        // 로봇이 없어야 이동 가능
        if (!containerBelt[movePosition].onRobot && 0 < containerBelt[movePosition].durability) {
            // "내리는 위치 포지션 X"
            if (movePosition != N - 1) {
                containerBelt[movePosition].onRobot = true
            }
            containerBelt[movePosition].durability -= 1
            containerBelt[curr].onRobot = false
        }
    }
}
