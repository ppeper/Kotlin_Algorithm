package Level1

class GcdLcm {
    fun solution(n: Int, m: Int): IntArray {
        val answer = IntArray(2)
        answer[0] = gcd(n, m)
        answer[1] = lcm(n, m)
        return answer
    }

    fun gcd(p: Int, q: Int): Int {
        return if (q == 0) p else gcd(q, p % q)
    }

    fun lcm(p: Int, q: Int): Int {
        return p * q / gcd(p, q)
    }
}