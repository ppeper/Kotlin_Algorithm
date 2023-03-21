package boj.최단거리

import sun.security.krb5.internal.KDCOptions.with

fun main() = with(System.`in`.bufferedReader()) {

    fun floyd(dist: Array<IntArray>, n: Int) {
        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    dist[i][j] = dist[i][j].coerceAtMost(dist[i][k] + dist[k][j])
                }
            }
        }
    }
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val dist = Array(n) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    floyd(dist, n)
    val bw = System.out.bufferedWriter()
    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        if (dist[a - 1][b - 1] <= c) {
            bw.write("Enjoy other party\n")
        } else {
            bw.write("Stay here\n")
        }
    }
    bw.run {
        flush()
        close()
    }
}