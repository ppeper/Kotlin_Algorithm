package boj.Problem1431

private lateinit var list: ArrayList<String>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    list = ArrayList()
    repeat(n) {
        list.add(readLine())
    }
    list.sortWith(
        compareBy<String> { it.length }
            .thenBy {
                it.filter { it.isDigit() }.sumOf { it - '0' }
            }
            .thenBy { it }
    )
    list.forEach {
        println(it)
    }
}