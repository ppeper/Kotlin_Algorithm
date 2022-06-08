package level1

import kotlin.math.abs

class Keypad {
    lateinit var keyboard: HashMap<String, IntArray>
    fun solution(numbers: IntArray, hand: String): String {
        setKeyboard()
        var answer = ""
        var left = "*"
        var right = "#"
        numbers.forEach { number ->
            when (number) {
                1,4,7 -> {
                    left = number.toString()
                    answer += "L"
                }
                3,6,9 -> {
                    right = number.toString()
                    answer += "R"
                }
                else -> {
                    val left_d = abs(keyboard[left]!![0] - keyboard[number.toString()]!![0]) + abs(keyboard[left]!![1] - keyboard[number.toString()]!![1])
                    val right_d = abs(keyboard[right]!![0] - keyboard[number.toString()]!![0]) + abs(keyboard[right]!![1] - keyboard[number.toString()]!![1])
                    if (left_d > right_d) {
                        answer += "R"
                        right = number.toString()
                    } else if (right_d > left_d) {
                        answer += "L"
                        left = number.toString()
                    } else {
                        if (hand == "right") {
                            answer += "R"
                            right = number.toString()
                        } else {
                            answer += "L"
                            left = number.toString()
                        }
                    }
                }
            }
        }
        return answer
    }

    private fun setKeyboard() {
        keyboard = hashMapOf()
        keyboard.apply {
            this["1"] = intArrayOf(0,0)
            this["2"] = intArrayOf(0,1)
            this["3"] = intArrayOf(0,2)
            this["4"] = intArrayOf(1,0)
            this["5"] = intArrayOf(1,1)
            this["6"] = intArrayOf(1,2)
            this["7"] = intArrayOf(2,0)
            this["8"] = intArrayOf(2,1)
            this["9"] = intArrayOf(2,2)
            this["*"] = intArrayOf(3,0)
            this["0"] = intArrayOf(3,1)
            this["#"] = intArrayOf(3,2)
        }
    }
}