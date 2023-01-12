package boj

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val treeMap = TreeMap<String, Double>()
    var count = 0
    while (true) {
        val name = readLine()
        if (name == null || name.isBlank()) break
        treeMap[name] = treeMap.getOrDefault(name, 0.0) + 1.0
        count++
    }
    while (treeMap.isNotEmpty()) {
        val curr = treeMap.pollFirstEntry()
        println("${curr.key} ${String.format("%.4f", curr.value / count * 100)}")
    }
}