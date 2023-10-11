package boj.`과거 문제들 정리`

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val answer = ArrayList<String>()
    var testCase = 0
    loop@ while (true) {
        val uList = ArrayList<Int>()
        val vList = ArrayList<Int>()
        while (true) {
            val u = nextInt()
            val v = nextInt()
            if (u == 0 && v == 0) break
            if (u == -1 && v == -1) break@loop
            uList.add(u)
            vList.add(v)
        }
        if (checkIsTree(uList, vList)) {
            answer.add("Case ${++testCase} is a tree.")
        } else {
            answer.add("Case ${++testCase} is not a tree.")
        }
    }
    answer.forEach {
        println(it)
    }
}

private fun checkIsTree(uList: ArrayList<Int>, vList: ArrayList<Int>): Boolean {
    var root = 0
    val nodes = (vList + uList).distinct()
    if (uList.isEmpty() && vList.isEmpty()) return true
    // 들어오는 간선확인
    if (vList.distinct().size != vList.size || nodes.size - 1 != uList.size) return false
    for (i in uList.indices) {
        val u = uList[i]
        if (!vList.contains(u)) {
            if (root == 0 || root == u) {
                root = u
            } else {
                // 이미 루트가 있으면 트리가 불가능
                return false
            }
        }
    }
    if (root == 0) return false
    return true
}
