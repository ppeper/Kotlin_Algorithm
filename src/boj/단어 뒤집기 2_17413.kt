package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val answer = StringBuilder()
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val string = readLine()
    val word = Stack<Char>()
    var check = false
    for (i in string.indices) {
        if (string[i] == '<') {
            addString(word)
            check = true
            answer.append(string[i])
        } else if (string[i] == '>') {
            answer.append(string[i])
            check = false
            addString(word)
        } else {
            if (check) {
                answer.append(string[i])
            } else {
                if (string[i] == ' ') {
                    addString(word)
                    answer.append(string[i])
                } else {
                    word.push(string[i])
                }
            }
        }
    }
    addString(word)
    println(answer)
}

private fun addString(word: Stack<Char>) {
    while (word.isNotEmpty()) {
        answer.append(word.pop())
    }
}
