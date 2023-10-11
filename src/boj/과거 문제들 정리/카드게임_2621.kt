package boj.`과거 문제들 정리`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.lang.Integer.min

private lateinit var cards: ArrayList<String>
private lateinit var numbers: ArrayList<Int>
private lateinit var numberForCount: HashMap<Int, Int>
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    cards = ArrayList()
    numbers = ArrayList()
    numberForCount = HashMap()
    // 카드 5개 입력
    repeat(5) {
        val (card, number) = readLine().split(' ')
        cards.add(card)
        numbers.add(number.toInt())
        numberForCount[number.toInt()] = numberForCount.getOrDefault(number.toInt(), 0) + 1
    }
    println(calculateScore())
}

private fun calculateScore(): Int {
    val checkCards = cards.toSet()
    val checkNumbers = numbers.toSet()
    val sortedNumbers = numbers.sorted()
    // 카드 5장이 모두 같음
    if (checkCards.size == 1 && checkNumbers(sortedNumbers)) {
        // 숫자가 연속적 -> 가장 높은 숫자에 900 더한다
        return sortedNumbers[4] + 900
    } else if (checkNumbers.size == 2) {
        if (numberForCount.containsValue(4)) {
            // 카드 5장 중 4장의 숫자가 같을 때 점수는 같은 숫자에 800을 더한다
            return getCard(4) + 800
        } else if (numberForCount.containsValue(3) && numberForCount.containsValue(2)) {
            // 카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같을 때 점수는 3장이 같은 숫자에 10을 곱하고 2장이 같은 숫자를 더한 다음 700을 더한다.
            return getCard(3) * 10 + getCard(2) + 700
        }
    } else if (checkCards.size == 1) {
        // 5장의 카드 색깔이 모두 같을 때 -> 가장 높은 숫자에 600을 더한다.
        return sortedNumbers[4] + 600
    } else if (checkNumbers(sortedNumbers)) {
        // 카드 5장의 숫자가 연속적일 때 점수는 가장 높은 숫자에 500을 더한다.
        return sortedNumbers[4] + 500
    } else if (checkNumbers.size == 3) {
        // 카드 5장 중 3장의 숫자가 같을 때 점수는 같은 숫자에 400을 더한다.
        if (numberForCount.containsValue(3)) {
            return getCard(3) + 400
        } else {
            val first = getCard(2)
            var second = 0
            for (key in numberForCount.keys) {
                if (numberForCount[key] == 2 && key != first) {
                    second = key
                    break
                }
            }
            if (second != 0) {
                // 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같을 때 점수는 같은 숫자 중 큰 숫자에 10을 곱하고 같은 숫자 중 작은 숫자를 더한 다음 300을 더한다.
                return max(first, second) * 10 + min(first, second) + 300
            }
        }
    } else if (checkNumbers.size == 4) {
        // 카드 5장 중 2장의 숫자가 같을 때 점수는 같은 숫자에 200을 더한다.
        return getCard(2) + 200
    }
    // 위의 어떤 경우에도 해당하지 않을 때 점수는 가장 큰 숫자에 100을 더한다.
    return sortedNumbers[4] + 100
}

private fun checkNumbers(sortedNumbers: List<Int>): Boolean {
    for (i in 0 until sortedNumbers.size - 1) {
        if (sortedNumbers[i] + 1 != sortedNumbers[i + 1]) {
            return false
        }
    }
    return true
}

private fun getCard(count: Int): Int {
    for (key in numberForCount.keys) {
        if (numberForCount[key] == count) {
            return key
        }
    }
    return -1
}
