package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    val list = readLine().split(' ').map { it.toInt() }
    val oppositeList = list.reversed().toMutableList()
    // 정방향 역방향 init
    for (i in list.indices) {
        val dir = oppositeList[i]
        val oppositeDir = getDir(dir)
        oppositeList[i] = oppositeDir
    }
    val testCase = readLine().toInt()
    var count = 0
    val answer = ArrayList<List<Int>>()
    repeat(testCase) {
        val test = readLine().split(' ').map { it.toInt() }
        if (isSame(test, list, oppositeList.toList())) {
            count++
            answer.add(test)
        }
    }
    // 출력
    println(count)
    for (i in answer.indices) {
        answer[i].forEach {
            print("$it ")
        }
        println()
    }
}

private fun getDir(dir: Int): Int {
    return when (dir) {
        1 -> 3
        2 -> 4
        3 -> 1
        else -> 2
    }
}

private fun isSame(test: List<Int>, list: List<Int>, oppositeList: List<Int>): Boolean {
    val queue: Queue<Int> = LinkedList(test)
    if (test == list || test == oppositeList) {
        return true
    } else {
        // 정방향 확인
        for (i in queue.indices) {
            queue.offer(queue.poll())
            if (queue.toList() == list || queue.toList() == oppositeList) {
                return true
            }
        }
    }
    // 모든 경우가 안되면 false
    return false
}

