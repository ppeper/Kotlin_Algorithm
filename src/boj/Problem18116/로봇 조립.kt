package boj.Problem18116

private lateinit var parents: IntArray
private lateinit var counts: IntArray
private var answer = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    parents = IntArray(1000001) { it }
    counts = IntArray(1000001) { 1 }
    val n = readLine().toInt()
    repeat(n) {
        val input = readLine().split(" ")
        if (input[0] == "I") {
            union(input[1].toInt(), input[2].toInt())
        } else {
            answer.append(counts[find(input[1].toInt())]).append("\n")
        }
    }
    println(answer)
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)

    if (parentA != parentB) {
        counts[parentA] += counts[parentB]
        parents[parentB] = parentA
    }
}

private fun find(node: Int): Int {
    if (parents[node] != node) {
        parents[node] = find(parents[node])
    }
    return parents[node]
}
