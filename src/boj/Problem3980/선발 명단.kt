package boj.Problem3980

private lateinit var players: Array<List<Int>>
private lateinit var pick: IntArray
private lateinit var visited: BooleanArray
private var answer = 0
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()
    repeat(n) {
        answer = 0
        players = Array(11) { listOf() }
        pick = IntArray(11)
        visited = BooleanArray(11)
        repeat(11) {
            players[it] = readLine().split(" ").map { it.toInt() }
        }
        pickPlayers(0)
        sb.append("$answer\n")
    }
    println(sb)
}

private fun pickPlayers(n: Int) {
    if (n == 11) {
        answer = answer.coerceAtLeast(pick.sum())
        return
    }
    for (idx in players.indices) {
        if (visited[idx]) continue
        if (players[idx][n] != 0) {
            visited[idx] = true
            pick[n] = players[idx][n]
            pickPlayers(n + 1)
            visited[idx] = false
        }
    }
}