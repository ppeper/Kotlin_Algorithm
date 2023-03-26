package boj.Problem1976

private lateinit var parent: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    parent = IntArray(n + 1) { it }
    for (i in 1..n) {
        val input = readLine().split(" ").map { it.toInt() }
        for (j in input.indices) {
            if (input[j] == 1) {
                if (findParent(i) != findParent(j + 1)) {
                    unionParent(i, j + 1)
                }
            }
        }
    }
    val input = readLine().split(" ").map { it.toInt() }
    var check = true
    val temp = findParent(input[0])
    for (i in 1 until input.size) {
        if (temp != findParent(input[i])) {
            check = false
            break
        }
    }
    if (check) println("YES") else println("NO")
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
    if (parentA < parentB) parent[parentB] = parentA
    else parent[parentA] = parentB
}