package boj.Problem26260

private val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val x = readLine().toInt()
    val tree = list.map { if (it == -1) x else it }.sorted()
    postOrder(tree, 0, n)
    println(sb.toString())
}

private fun postOrder(tree: List<Int>, start: Int, end: Int) {
    val mid = (start + end) / 2
    if (start < end) {
        postOrder(tree, start, mid)
        postOrder(tree, mid + 1, end)
        sb.append("${tree[mid]} ")
    }
}
