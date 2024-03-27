package boj.Problem2015

private lateinit var sum: LongArray
private lateinit var hm: HashMap<Long, Long>
private var answer = 0L
fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    sum = LongArray(n + 1)
    hm = HashMap()
    readLine().split(" ").map { it.toLong() }.forEachIndexed { index, i ->
        sum[index + 1] = sum[index] + i
        if (sum[index + 1] == k.toLong()) answer++
        // map에서 누적합이 k가 나올 수 있는 value 값 개수 확인
        answer += hm.getOrDefault(sum[index + 1] - k, 0)
        hm[sum[index + 1]] = hm.getOrDefault(sum[index + 1], 0) + 1
    }
    println(answer)
}

