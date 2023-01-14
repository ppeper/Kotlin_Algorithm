package boj

fun main() = with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    var T = readLine().toInt()
    val target = readLine().toInt()
    var position = -1
    // 첫 시작은 2번 반복
    var count = 2
    loop@ while (true) {
        val game = arrayListOf(0, 1, 0, 1)
        repeat(count) { game.add(0) }
        repeat(count) { game.add(1) }
        count++
        // 뻔데기 반복
        for (scream in game) {
            position++
            if (scream == target) T--
            if (T == 0) break@loop
        }
    }
    println(position % N)
}