package boj.Problem4195

private lateinit var parent: IntArray
private lateinit var friend: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val answer = StringBuilder()
    repeat(t) {
        val n = readLine().toInt()
        parent = IntArray(n * 2) { it }
        friend = IntArray(n * 2) { 1 }
        var idx = 0
        val hm = HashMap<String, Int>()
        repeat(n) {
            val (a, b) = readLine().split(" ")
            if (!hm.containsKey(a)) hm[a] = idx++
            if (!hm.containsKey(b)) hm[b] = idx++
            answer.append(union(hm[a]!!, hm[b]!!)).append("\n")
        }
    }
    println(answer)
}

private fun union(a: Int, b: Int): Int {
    val pa = findParent(a)
    val pb = findParent(b)
    if (pa != pb) {
        // 둘이 친구로 만들어 준다
        parent[pb] = pa
        friend[pa] += friend[pb]
    }
    return friend[pa]
}

private fun findParent(node: Int): Int {
    if (node != parent[node]) {
        parent[node] = findParent(parent[node])
    }
    return parent[node]
}