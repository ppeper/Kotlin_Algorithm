package boj.Problem20040

private lateinit var parent: IntArray
private lateinit var line: Array<List<Int>>
fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var answer = 0
    parent = IntArray(n + 1) { it }
    line = Array(m) { readLine().split(" ").map { it.toInt() } }
    for (i in line.indices) {
        val (a, b) = line[i]
        if (getParent(a) == getParent(b)) {
            answer = i + 1
            break
        } else {
            union(a, b)
        }
    }
    println(answer)
}

private fun union(a: Int, b: Int) {
    val pa = getParent(a)
    val pb = getParent(b)
    if (pa < pb) parent[pb] = pa
    else parent[pa] = pb
}

private fun getParent(node: Int): Int {
    if (node != parent[node]) {
        parent[node] = getParent(parent[node])
    }
    return parent[node]
}
