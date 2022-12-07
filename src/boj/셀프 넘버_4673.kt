package boj

fun main() {
    val selfNumberSet = HashSet<Int>()
    for (number in 1..10000) {
        var buffer = number
        for (num in number.toString().toCharArray()) {
            buffer += (num - '0')
        }
        if (!selfNumberSet.contains(number)) println(number)
        selfNumberSet.add(buffer)
    }
}