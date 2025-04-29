package boj.Problem2346

fun main() = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<Int>()
    val n = readLine().toInt()
    val list = readLine().split(" ").mapIndexed { index, s ->
        Pair(index + 1, s.toInt())
    }.toMutableList()
    repeat(n - 1) {
        list.removeFirst().also { (index, s) ->
            answer.add(index)
            if (0 < s - 1) {
                repeat(s - 1) {
                    list.removeFirst().also {
                        list.add(it)
                    }
                }
            } else {
                val count = -s
                repeat(count) {
                    list.removeLast().also {
                        list.add(0, it)
                    }
                }
            }
        }
    }
    list.removeLast().also {
        answer.add(it.first)
    }
    println(answer.joinToString(" "))
}