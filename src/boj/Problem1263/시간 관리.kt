package boj.Problem1263

data class Work(
    val overTime: Int,
    val deadLine: Int
)

private lateinit var list: MutableList<Work>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    list = ArrayList()
    repeat(n) {
        val (overTime, deadLine) = readLine().split(" ").map { it.toInt() }
        list.add(Work(overTime, deadLine))
    }
    list.sortByDescending { it.deadLine }
    var time = list[0].deadLine - list[0].overTime
    for (i in 1 until list.size) {
        if (list[i].deadLine < time) {
            time = list[i].deadLine - list[i].overTime
        } else {
            time -= list[i].overTime
        }
    }
    if (0 <= time) println(time) else println(-1)
}