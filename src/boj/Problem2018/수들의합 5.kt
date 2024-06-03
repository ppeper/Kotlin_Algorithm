package boj.Problem2018

fun main() = with(System.`in`.bufferedReader()) {
    val number = readLine().toInt()

    var count = 0
    var start = 1
    var end = 2

    while (start < end) {
        var sum = 0
        for (i in start .. end) {
            sum += i
        }
        if (sum == number) {
            count++
        }
        if (number < sum) {
            start++
        } else {
            end++
        }
    }
    println(count + 1)
}