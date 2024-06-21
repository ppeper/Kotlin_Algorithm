package boj.Problem2141

data class Node(
    val x: Int,
    val people: Long
)
private lateinit var list: ArrayList<Node>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    list = ArrayList()
    repeat(n) {
        val (x, people) = readLine().split(" ").map { it.toInt() }
        list.add(Node(x, people.toLong()))
    }
    list.sortBy { it.x }
    val peoples = list.sumOf { it.people } + 1
    var count = 0L
    for ((x, people) in list) {
        count += people
        if (peoples / 2 <= count) {
            println(x)
            break
        }
    }
}