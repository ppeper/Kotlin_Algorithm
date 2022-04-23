package Level2

// 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//numbers는 길이 1 이상 7 이하인 문자열입니다.
//numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

import kotlin.math.sqrt

class Prime {
    var list = mutableSetOf<Int>()
    lateinit var isChecked: BooleanArray

    fun solution(numbers: String): Int {
        val split = numbers.map { it.toString() }
        isChecked = BooleanArray(split.size)
        // 만들수있는 숫자 다 탐색
        for (i in 1..split.size) {
            search(i, split, 0, "")
        }
        return list.size
    }

    private fun search(length: Int, split: List<String>, depth: Int, str: String) {
        var number = str
        if (depth == length) {
            if (checkPrime(number.toInt())) {
                list.add(number.toInt())
            }
            return
        }
        for (i in split.indices) {
            if (!isChecked[i]) {
                isChecked[i] = true
                number += split[i]
                search(length, split, depth + 1, number)
                // 붙인값 삭제
                number = str
                isChecked[i] = false
            }
        }
    }

    // 소수확인
    private fun checkPrime(num: Int): Boolean {
        val sqrt = sqrt(num.toDouble()).toInt()
        return if (num == 1) false
        else if (num == 2) {
            true
        } else if (num % 2 == 0) {
            false
        } else {
            var i = 3
            while (i <= sqrt) {
                if (num % i == 0) {
                    return false
                }
                i += 2
            }
            // 다 안나눠지면 소수
            true
        }
    }
}