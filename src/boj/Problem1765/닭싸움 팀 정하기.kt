package boj.Problem1765

import java.util.LinkedList

private lateinit var enemy: Array<LinkedList<Int>>
private lateinit var parent: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    parent = IntArray(n + 1) { it }
    enemy = Array(n + 1) { LinkedList() }
    val m = readLine().toInt()
    repeat(m) {
        val (relation, a, b) = readLine().split(" ")
        if (relation == "F") {
            union(a.toInt(), b.toInt())
        } else {
            enemy[a.toInt()].add(b.toInt())
            enemy[b.toInt()].add(a.toInt())
        }
    }
    for (i in 1 until enemy.size) {
        checkFriends(i)
    }
    val count = parent.map { find(it) }.distinct().count()
    println(count - 1)
}

private fun checkFriends(i: Int) {
    for (enemies in enemy[i]) {
        for (enemyInEnemy in enemy[enemies]) {
            union(i, enemyInEnemy)
        }
    }
}

private fun union(a: Int, b: Int) {
    val parentA = find(parent[a])
    val parentB = find(parent[b])
    if (parentA < parentB) parent[parentB] = parentA
    else parent[parentA] = parentB
}

private fun find(node: Int): Int {
    if (parent[node] != node) {
        parent[node] = find(parent[node])
    }
    return parent[node]
}