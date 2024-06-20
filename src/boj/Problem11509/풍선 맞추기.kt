package boj.Problem11509

private lateinit var list: List<Int>
private lateinit var arrow: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    list = readLine().split(" ").map { it.toInt() }
    val max = list.max()
    var answer = 0
    arrow = IntArray(max + 1)
    for (height in list) {
        // 화살을 쏴야함
        if (arrow[height] == 0) {
            answer++
        } else if (0 < arrow[height]) {
            // 화살이 있음 -> 풍선에 맞고 높이 감소
            arrow[height] -= 1
        }
        arrow[height - 1] += 1
    }
    println(answer)
}