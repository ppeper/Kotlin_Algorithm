package boj

fun main() {
    val test = readln().toInt()
    val answer = Array(test) { "error" }
    loop@ for (i in 0 until test) {
        val oper = readLine()!!
        val size = readln().toInt()
        val input = readLine()!!.removePrefix("[").removeSuffix("]")
        val list = ArrayDeque<Int>()
        if (input.isNotBlank()) {
            input.split(",").forEach {
                list.add(it.toInt())
            }
        }
        var checkR = false
        for (j in oper.indices) {
            when (oper[j]) {
                'R' -> { checkR = !checkR }
                'D' -> {
                    if (list.isEmpty()) {
                        continue@loop
                    } else {
                        if (checkR) {
                            list.removeLast()
                        } else {
                            list.removeFirst()
                        }
                    }
                }
            }
        }
        if (checkR) {
            answer[i] = list.reversed().joinToString(",", "[", "]")
        } else {
            answer[i] = list.toList().joinToString(",", "[", "]")
        }
    }
    answer.forEach {
        println(it)
    }
}