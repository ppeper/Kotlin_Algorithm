package boj.`과거 문제들 정리`

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (N, W) = nextLine().split(' ').map { it.toInt() }
    val tree = Array(N) { LinkedList<Int>() }
    repeat(N - 1) {
        val U = nextInt() - 1
        val V = nextInt() - 1
        tree[U].add(V)
        tree[V].add(U)
    }
    var leafs = tree.count { it.size == 1 }
    if (tree[0].size == 1) leafs -= 1
    println(W.toDouble() / leafs)
}