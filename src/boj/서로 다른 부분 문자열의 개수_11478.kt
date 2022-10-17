package boj

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var string: String
private lateinit var words: HashSet<String>
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    string = readLine()
    words = HashSet()
    for (i in 1..string.length) {
        makeSubString(i)
    }
    println(words.size)
}

private fun makeSubString(end: Int) {
    for (start in string.indices) {
        // 범위에 안넘어 간다면
        if (start + end <= string.length) {
            words.add(string.substring(start, start + end))
        }
    }
}
