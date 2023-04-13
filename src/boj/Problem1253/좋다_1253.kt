package boj.Problem1253

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var answer = 0
    val numbers = readLine().split(" ").map { it.toInt() }.sorted()
    // 첫번째 수부터 확인
    for (i in numbers.indices) {
        val number = numbers[i]
        var start = 0
        var end = n - 1
        // 이동하면서 탐색
        while (start < end) {
            val sum = numbers[start] + numbers[end]
            if (start == i) {
                start++
                continue
            }
            if (end == i) {
                end--
                continue
            }
            if (sum == number) {
                answer++
                break
            } else if (sum < number) {
                // 앞에 숫자를 키워줌
                start += 1
            } else {
                // 뒤 숫자를 작게 해줌
                end -= 1
            }
        }
    }
    println(answer)
}