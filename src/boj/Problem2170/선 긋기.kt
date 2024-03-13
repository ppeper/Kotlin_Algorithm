package boj.Problem2170

data class Node(
    val start: Int = 0,
    val end: Int = 0
)
private lateinit var line: Array<Node>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    line = Array(n) { Node() }
    repeat(n) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        line[it] = Node(start, end)
    }
    line.sortWith(compareBy { it.start })
    var length = 0
    var start = line[0].start
    var end = line[0].end
    for (i in 1 until line.size) {
        // 새로 다시 그려짐
        if (end < line[i].start) {
            length += end - start
            start = line[i].start
        }
        if (end < line[i].end) {
            end = line[i].end
        }
    }
    println(length + end - start)
}
