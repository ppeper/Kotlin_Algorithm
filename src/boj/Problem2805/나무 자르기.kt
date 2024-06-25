package boj.Problem2805

private lateinit var list: List<Long>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toLong() }
    list = readLine().split(" ").map { it.toLong() }.sorted()
    var left = 1L
    var right = list.max()
    while (left <= right) {
        val mid = (left + right) / 2
        val height = getHeight(mid)

        // 얻을 수 있는 나무가 더 많은 -> 더 크게 잘라도 됨
        if (m <= height) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(right)
}

private fun getHeight(height: Long): Long {
    var sum = 0L
    list.forEach {
        if (height < it) sum += (it - height)
    }
    return sum
}
