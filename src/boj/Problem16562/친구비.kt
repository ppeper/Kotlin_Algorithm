package boj.Problem16562

private lateinit var parent: IntArray
private lateinit var cost: List<Int>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(n) { it }
    cost = readLine().split(" ").map { it.toInt() }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        union(a - 1, b - 1)
    }
    var result = 0
    val visited = BooleanArray(n)
    for (i in 0 until n) {
        val parent = findParent(i)
        if (visited[parent]) continue
        visited[parent] = true
        result += cost[parent]
    }
    if (result <= k) println(result) else println("Oh no")
}

private fun union(a: Int, b: Int) {
    val parentA = findParent(a)
    val parentB = findParent(b)
    if (parentA != parentB) {
        // 친구비용이 작은쪽으로 parent 업데이트
        if (cost[parentA] <= cost[parentB]) parent[parentB] = parentA
        else parent[parentA] = parentB
    }
}

private fun findParent(a: Int): Int {
    if (parent[a] != a) {
        parent[a] = findParent(parent[a])
    }
    return parent[a]
}
