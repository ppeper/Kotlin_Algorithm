package boj.Problem1911

private lateinit var list: Array<List<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    list = Array(n) { readLine().split(" ").map { it.toInt() }}.also {
        it.sortWith(compareBy<List<Int>> { it[0] }.thenBy { it[1] })
    }
    var answer = 0
    var range = 0
    list.forEach { (s, e) ->
        if (range < s) {
            range = s
        }
        // 웅덩이 깔아주기
        if (range < e) {
            while (range < e) {
                range += l
                answer++
            }
        }
    }
    println(answer)
}