package boj

fun main() {
    val (N, M) = readLine()!!.split(' ').map { it.toInt() }
    val setA = hashSetOf<String>().apply { repeat(N) { add(readln()) } }
    val setB = hashSetOf<String>().apply { repeat(M) { add(readln()) } }
    val answer = setA.filter { setB.contains(it) }.sorted()
    // 듣도 못한사람과 보도 못한사람만 필터후
    println(answer.size)
    answer.forEach {
        println(it)
    }
}