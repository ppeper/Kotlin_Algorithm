package boj.Problem7570

private lateinit var front: IntArray
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    front = IntArray(n + 1)
    val list = readLine().split(" ").map { it.toInt() }
    for (num in list) {
        front[num] = front[num - 1] + 1
    }
    print(n - front.max())
}