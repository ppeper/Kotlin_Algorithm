package level3

// 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
//
//12 = 5 + 5 + (5 / 5) + (5 / 5)
//12 = 55 / 5 + 5 / 5
//12 = (55 + 5) / 5
//
//5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
//이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
//
//제한사항
//N은 1 이상 9 이하입니다.
//number는 1 이상 32,000 이하입니다.
//수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
//최솟값이 8보다 크면 -1을 return 합니다.

class Expression {
    fun solution(N: Int, number: Int): Int {
        var answer = -1
        val list = mutableListOf<MutableSet<Int>>()
        (1..8).forEach {
            list.add(mutableSetOf((N.toString().repeat(it).toInt())))
        }
        println(list)
        if (N == number) {
            return 1
        }
        for (i in 1..7) {
            for (j in 0 until i) {
                for (x in list[j]) {
                    for (y in list[i - j - 1]) {
                        list[i].add(x + y)
                        list[i].add(x - y)
                        list[i].add(x * y)
                        if (y > 0) {
                            list[i].add(x / y)
                        }
                    }
                }
            }
            if (list[i].contains(number)) {
                answer = i + 1
                break
            }
        }
        return answer
    }
}