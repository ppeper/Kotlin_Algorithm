package boj.Problem20366

private lateinit var list: List<Int>
data class SnowMan(val x: Int, val y: Int, val height: Int)
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    list = readLine().split(" ").map { it.toInt() }
    val snowManList = mutableListOf<SnowMan>()
    for (i in 0 until list.size - 1) {
        for (j in i + 1 until list.size) {
            snowManList.add(SnowMan(i, j, list[i] + list[j]))
        }
    }
    snowManList.sortBy { it.height }
    var answer = Int.MAX_VALUE
    for (i in 0 until snowManList.size - 1) {
        val a = snowManList[i]
        val b = snowManList[i + 1]
        if (b.height - a.height < answer) {
            if (a.x == b.x || a.x == b.y || a.y == b.x || a.y == b.y) continue
            answer = b.height - a.height
        }
    }
    println(answer)
}