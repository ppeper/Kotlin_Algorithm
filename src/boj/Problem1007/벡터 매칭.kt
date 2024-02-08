package boj.Problem1007

import kotlin.math.pow
import kotlin.math.sqrt

private lateinit var pick: IntArray
private lateinit var list: Array<List<Int>>
private var answer = StringBuilder()
private var xTotal = 0
private var yTotal = 0
private var min = 0.0
fun main() = with(System.`in`.bufferedReader()) {
    val test = readLine().toInt()
    repeat(test) {
        min = Double.MAX_VALUE
        xTotal = 0
        yTotal = 0
        val n = readLine().toInt()
        pick = IntArray(n / 2)
        list = Array(n) {
            readLine().split(" ").map { it.toInt() }.also {
                xTotal += it[0]
                yTotal += it[1]
            }
        }
        comb(0, 0, n / 2)
        answer.append("$min\n")
    }
    println(answer)
}

private fun comb(start: Int, count: Int, n: Int) {
    if (count == n) {
        calculate()
        return
    }
    for (i in start until list.size) {
        pick[count] = i
        comb(i + 1, count + 1, n)
    }
}

private fun calculate() {
    // 더해야하는 좌표 총합
    var x1Total = 0
    var y1Total = 0
    for (i in pick) {
        x1Total += list[i][0]
        y1Total += list[i][1]
    }
    // 빼야하는 좌표 총합
    val x2Total = xTotal - x1Total
    val y2Total = yTotal - y1Total
    val x = (x1Total - x2Total).toDouble().pow(2.0)
    val y = (y1Total - y2Total).toDouble().pow(2.0)
    min = min.coerceAtMost(sqrt(x + y))
}
