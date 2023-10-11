package boj.`과거 문제들 정리`


private const val MOD = 1000000
fun main() {
    val password = readln()
    val decrypt = LongArray(password.length) { 0 }
    if (password.startsWith("0") || 5000 < password.length) {
        println(0)
        return
    } else {
        for (i in decrypt.indices) {
            if (i == 0) {
                decrypt[i] = 1
            } else {
                // 하나씩 문자를 해석
                if (password[i] != '0') {
                    decrypt[i] += decrypt[i - 1]
                }
                // 두 단어 확인
                if (password.substring(i - 1, i + 1).toInt() in 10..26) {
                    if (i == 1) {
                        decrypt[1] = decrypt[1] + 1
                    } else {
                        decrypt[i] = (decrypt[i] + decrypt[i - 2]) % MOD
                    }
                }
            }
        }
    }
    println(decrypt[password.length - 1] % MOD)
}