package boj

import java.util.*

fun main() {
    val size = readln().toInt()
    val tree = Array(size + 1) { LinkedList<Int>() }
    repeat(size - 1) {
        val input = readLine()!!.split(' ').map { it.toInt() }
        tree[input[0]].add(input[1])
        tree[input[1]].add(input[0])
    }
    val parent = IntArray(size + 1) { 1 }
    val visited = BooleanArray(size + 1)
    visited[1] = true
    findParent(1, tree, visited, parent)
    for (j in 2 until parent.size) {
        println(parent[j])
    }
}

private fun findParent(root: Int, tree: Array<LinkedList<Int>>, visited: BooleanArray, parent: IntArray) {
    for (child in tree[root]) {
        if (!visited[child]) {
            visited[child] = true
            // 현재 연결되어있는 root 가 부모노드
            parent[child] = root
            findParent(child, tree, visited, parent)
        }
    }
}
