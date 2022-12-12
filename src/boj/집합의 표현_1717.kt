package boj

import java.lang.StringBuilder
import java.util.Scanner

private lateinit var parent: IntArray
fun main() = with(Scanner(System.`in`)) {
    val answer = StringBuilder()
    val size = nextInt()
    parent = IntArray(size + 1)
    for (index in 1 until parent.size) {
        parent[index] = index
    }
    val m = nextInt()
    for (i in 0 until m) {
        val op = nextInt()
        val a = nextInt()
        val b = nextInt()
        if (op == 0) {
            unionParent(a, b)
        } else {
            if (findParent(a) == findParent(b)) {
                answer.append("YES\n")
            } else {
                answer.append("NO\n")
            }
        }
    }
    println(answer)
}

private fun findParent(node: Int): Int {
    if (parent[node] != node) {
        parent[node] = findParent(parent[node])
    }
    return parent[node]
}

private fun unionParent(a: Int, b: Int) {
    val parentA = findParent(a)
    val parentB = findParent(b)
    if (parentA != parentB) {
        // 둘이 합칩합을 만들어준다 -> 부모를 똑같이 만들어줌
        parent[parentA] = parentB
    }
}
