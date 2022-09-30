package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    var count = 0
    for (i in 0 until size) {
        val word = readLine()
        val set = HashSet<Char>()
        if (checkWord(set, word)) count++
    }
    println(count)
}

private fun checkWord(set: HashSet<Char>, word: String): Boolean {
    var prev: Char = '0'
    for (c in word.toCharArray()) {
        if (prev == c) {
            continue
        } else {
            if (set.contains(c)) {
                return false
            }
            set.add(c)
            prev = c
        }
    }
    return true
}