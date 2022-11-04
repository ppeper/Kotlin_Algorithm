package boj

fun main() {
    val size = readln().toInt()
    val list = mutableSetOf<String>().apply {
        repeat(size) {
            add(readln())
        }
    }.toList()
    val sortedList = list.sortedWith(
        compareBy<String> { it.length }
            .thenBy { it }
    )
    sortedList.forEach {
        println(it)
    }
}