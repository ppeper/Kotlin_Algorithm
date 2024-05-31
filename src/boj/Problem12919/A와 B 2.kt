package boj.Problem12919

private var answer = 0
fun main() = with(System.`in`.bufferedReader()) {
    val source = readLine()
    val target = readLine()
    isConvertToTarget(source, target)
    println(answer)
}

private fun isConvertToTarget(source: String, target: String) {
    if (answer == 1) return
    if (source.length == target.length) {
        if (source == target) answer = 1
        return
    }
    if (target.last() == 'A') {
        isConvertToTarget(source, target.substring(0, target.length - 1))
    }
    if (target.first() == 'B') {
        isConvertToTarget(source, target.substring(1).reversed())
    }
}
